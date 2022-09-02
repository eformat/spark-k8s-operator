package io.fabric8.kubernetes.client.dsl.internal;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class WatcherWebSocketListener<T> extends WebSocketListener {
    protected static final Logger logger = LoggerFactory.getLogger(WatcherWebSocketListener.class);
    protected final AtomicReference<WebSocket> webSocketRef;
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final AtomicBoolean reconnectPending = new AtomicBoolean(false);
    private final BlockingQueue<Object> queue;
    protected final AbstractWatchManager<T> manager;

    protected WatcherWebSocketListener(AbstractWatchManager<T> manager, BlockingQueue<Object> queue, AtomicReference<WebSocket> webSocketRef) {
        this.manager = manager;
        this.queue = queue;
        this.webSocketRef = webSocketRef;
    }

    public void onOpen(WebSocket webSocket, Response response) {
        if (response != null && response.body() != null) {
            response.body().close();
        }

        logger.debug("WebSocket successfully opened");
        this.webSocketRef.set(webSocket);
        this.manager.resetReconnectAttempts();
        this.started.set(true);
        this.queue.clear();
        this.queue.add(true);
    }

    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (this.manager.isForceClosed()) {
            logger.debug("Ignoring onFailure for already closed/closing websocket", t);
            if (response != null && response.body() != null) {
                response.body().close();
            }

        } else {
            if (response != null) {
                int code = response.code();
                if (200 == code || 503 == code) {
                    this.pushException(new KubernetesClientException("Received " + code + " on websocket", code, (Status)null));
                    this.closeBody(response);
                    return;
                }

                Status status = OperationSupport.createStatus(response);
                this.closeBody(response);
                logger.warn("Exec Failure: HTTP {}, Status: {} - {}", new Object[]{code, status.getCode(), status.getMessage(), t});
                if (!this.started.get()) {
                    this.pushException(new KubernetesClientException(status));
                }
            } else {
                logger.warn("Exec Failure", t);
                if (!this.started.get()) {
                    this.pushException(new KubernetesClientException("Failed to start websocket", t));
                }else{
                    logger.warn("Exec Failure - Killing Self", t);
                    System.exit(0);
                }
            }

            if (this.manager.cannotReconnect()) {
                this.manager.closeEvent(new WatcherException("Connection failure", t));
            } else {
                this.scheduleReconnect();
            }
        }
    }

    private void pushException(KubernetesClientException exception) {
        this.queue.clear();
        if (!this.queue.offer(exception)) {
            logger.debug("Couldn't add exception {} to queue", exception.getLocalizedMessage());
        }

    }

    private void closeBody(Response response) {
        if (response.body() != null) {
            response.body().close();
        }

    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        this.onMessage(webSocket, bytes.utf8());
    }

    public void onClosing(WebSocket webSocket, int code, String reason) {
        logger.debug("Socket closing: {}", reason);
        webSocket.close(code, reason);
    }

    public void onClosed(WebSocket webSocket, int code, String reason) {
        logger.debug("WebSocket close received. code: {}, reason: {}", code, reason);
        if (this.manager.isForceClosed()) {
            logger.debug("Ignoring onClose for already closed/closing websocket");
        } else if (this.manager.cannotReconnect()) {
            this.manager.closeEvent(new WatcherException("Connection unexpectedly closed"));
        } else {
            this.scheduleReconnect();
        }
    }

    private void scheduleReconnect() {
        logger.debug("Submitting reconnect task to the executor");
        this.manager.submit(new NamedRunnable("scheduleReconnect") {
            public void execute() {
                if (!WatcherWebSocketListener.this.reconnectPending.compareAndSet(false, true)) {
                    WatcherWebSocketListener.logger.debug("Reconnect already scheduled");
                } else {
                    WatcherWebSocketListener.this.webSocketRef.set((WebSocket) null);

                    try {
                        WatcherWebSocketListener.logger.debug("Scheduling reconnect task");
                        WatcherWebSocketListener.this.manager.schedule(new NamedRunnable("reconnectAttempt") {
                            public void execute() {
                                try {
                                    WatcherWebSocketListener.this.manager.runWatch();
                                    WatcherWebSocketListener.this.reconnectPending.set(false);
                                } catch (Exception var2) {
                                    WatcherWebSocketListener.logger.error("Exception in reconnect", var2);
                                    WatcherWebSocketListener.this.webSocketRef.set((WebSocket) null);
                                    WatcherWebSocketListener.this.manager.closeEvent(new WatcherException("Unhandled exception in reconnect attempt", var2));
                                    WatcherWebSocketListener.this.manager.close();
                                }

                            }
                        }, WatcherWebSocketListener.this.manager.nextReconnectInterval(), TimeUnit.MILLISECONDS);
                    } catch (RejectedExecutionException var2) {
                        WatcherWebSocketListener.this.reconnectPending.set(false);
                    }

                }
            }
        });
    }
}
