package com.acme.operators.okhttp3;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ErrorEventListener extends EventListener {
    private static final Logger logger = LoggerFactory.getLogger(ErrorEventListener.class);

    @Override
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException ioe) {
        logger.error("HTTP Connection Failed with exception", ioe, ioe.getCause());
        if (ioe instanceof SocketException || ioe instanceof SocketTimeoutException){
            logger.error("Self destructing NOW");
            System.exit(0);
        }

    }
}
