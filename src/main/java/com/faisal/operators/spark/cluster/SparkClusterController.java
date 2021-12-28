package com.faisal.operators.spark.cluster;

import com.faisal.operators.spark.Constants;
import com.faisal.operators.spark.types.Master;
import com.faisal.operators.spark.types.Worker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.javaoperatorsdk.operator.api.*;
import io.javaoperatorsdk.operator.processing.event.EventSourceManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static io.javaoperatorsdk.operator.api.Controller.WATCH_CURRENT_NAMESPACE;

//https://github.com/fabric8io/kubernetes-client/blob/master/doc/CHEATSHEET.md#ingress
//@Controller(namespaces = "default")
@Controller(namespaces = WATCH_CURRENT_NAMESPACE)
public class SparkClusterController implements ResourceController<SparkClusterResource> {


    @PostConstruct
    public void buildState() {
        RunningClusters runningClusters = getClusters();
        CustomResourceDefinitionContext sparkClusterCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkClusterResource.class);
        var allSparkClusters =
                kubernetesClient.customResources(SparkClusterResource.class)
                        .inNamespace(namespace)
                        .list();
        for (SparkClusterResource sparkClusterResource : allSparkClusters.getItems()) {
            SparkCluster sparkClusterSpec = sparkClusterResource.getSpec();
            if (sparkClusterSpec.getName() == null || sparkClusterSpec.getName().isEmpty()) {
                sparkClusterSpec.setName(sparkClusterResource.getMetadata().getName());
                sparkClusterSpec.setNamespace(sparkClusterResource.getMetadata().getNamespace());
            }

            runningClusters.put(sparkClusterSpec);
        }
    }


    private final KubernetesClient kubernetesClient;

    ObjectMapper mapper = new ObjectMapper();

    public SparkClusterController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @ConfigProperty(name = "quarkus.kubernetes-client.namespace")
    String namespace;

    private final Logger log = LoggerFactory.getLogger(SparkClusterController.class);

    @Override
    public DeleteControl deleteResource(SparkClusterResource sparkClusterResource, Context<SparkClusterResource> context) {
        final var spec = sparkClusterResource.getSpec();

        log.info("Received {} ", sparkClusterResource);

        String namespace = sparkClusterResource.getMetadata().getNamespace();
        log.info("Received NS {} ", namespace);

        CustomResourceDefinitionContext sparkClusterCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkClusterResource.class);

        Map<String, Object> sparkClustersWithName = kubernetesClient.customResource(sparkClusterCustomResource).get(namespace, sparkClusterResource.getMetadata().getName());
        SparkCluster sparkClusterSpec = mapper.convertValue(sparkClustersWithName.get("spec"), SparkCluster.class);

        String name = sparkClusterSpec.getName();
//        updateStatus(sparkClusterSpec, "deleted");
        kubernetesClient.services().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.replicationControllers().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.pods().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.persistentVolumeClaims().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.network().ingress().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        getClusters().delete(name);
        return DeleteControl.DEFAULT_DELETE;
    }

    @Override
    public UpdateControl<SparkClusterResource> createOrUpdateResource(SparkClusterResource sparkClusterResource, Context<SparkClusterResource> context) {
        final var spec = sparkClusterResource.getSpec();

        log.info("Received {} ", sparkClusterResource);

        String namespace = sparkClusterResource.getMetadata().getNamespace();
        log.info("Received NS {} ", namespace);

        CustomResourceDefinitionContext sparkClusterCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkClusterResource.class);

        Map<String, Object> sparkClustersWithName = kubernetesClient.customResource(sparkClusterCustomResource).get(namespace, sparkClusterResource.getMetadata().getName());


//        Map<String, Object> cr = kubernetesClient.customResource(sparkClusterCustomResource).get(namespace, );
//        SparkCluster sparkClusterSpec = mapper.convertValue(sparkClustersWithName.get("spec"), SparkCluster.class);

        var replicationController =
                kubernetesClient.replicationControllers().inNamespace(namespace).withName(sparkClusterResource.getMetadata().getName() + "-m").get();

        SparkCluster sparkClusterSpec = mapper.convertValue(sparkClustersWithName.get("spec"), SparkCluster.class);
        if (sparkClusterSpec.getName() == null || sparkClusterSpec.getName().isEmpty()) {
            sparkClusterSpec.setName(sparkClusterResource.getMetadata().getName());
            sparkClusterSpec.setNamespace(sparkClusterResource.getMetadata().getNamespace());
        }

        if (replicationController == null) {
            log.info("its a new request");

            doAdd(sparkClusterSpec);
//            updateStatus(sparkClusterSpec, "ready");
            sparkClusterResource.setStatus(new SparkClusterStatus("ready", new Date()));
            return UpdateControl.updateStatusSubResource(sparkClusterResource);

        } else {
            log.info("already exists");
            doModify(sparkClusterSpec);
            sparkClusterResource.setStatus(new SparkClusterStatus("ready", new Date()));
            return UpdateControl.updateStatusSubResource(sparkClusterResource);
        }

//        return UpdateControl.noUpdate();
    }


    /**
     * This method verifies if any two instances of SparkCluster are the same ones up to the number of
     * workers. This way we can call the scale instead of recreating the whole cluster.
     *
     * @param oldC the first instance of SparkCluster we are comparing
     * @param newC the second instance of SparkCluster we are comparing
     * @return true if both instances represent the same spark cluster but differs only in number of workers (it is safe
     * to call scale method)
     */
    private boolean isOnlyScale(SparkCluster oldC, SparkCluster newC) {
        boolean retVal = oldC.getWorker().getInstances() != newC.getWorker().getInstances();
        int backup = Optional.ofNullable(newC.getWorker()).orElse(new Worker()).getInstances();
        newC.getWorker().setInstances(oldC.getWorker().getInstances());
        retVal &= oldC.equals(newC);
        newC.getWorker().setInstances(backup);
        return retVal;
    }

    public void doModify(SparkCluster sparkClusterSpec) {
        String name = sparkClusterSpec.getName();

        // if an empty master/worker was passed
        if (null == sparkClusterSpec.getMaster()) {
            sparkClusterSpec.setMaster(new Master());
        }
        if (null == sparkClusterSpec.getWorker()) {
            sparkClusterSpec.setWorker(new Worker());
        }
        int newWorkers = Optional.ofNullable(sparkClusterSpec.getWorker()).orElse(new Worker()).getInstances();

        SparkCluster existingCluster = getClusters().getCluster(name);
        if (null == existingCluster) {
            log.error("something went wrong, unable to scale existing cluster. Perhaps it wasn't deployed properly.");
            updateStatus(sparkClusterSpec, "error, unable to scale existing cluster");
            return;
        }

        if (isOnlyScale(existingCluster, sparkClusterSpec)) {
            log.info("scaling from {} worker replicas to {}", existingCluster.getWorker().getInstances(), newWorkers);
            kubernetesClient.replicationControllers().inNamespace(namespace).withName(name + "-w").scale(newWorkers);

            // update metrics
            MetricsHelper.workers.labels(sparkClusterSpec.getName(), namespace).set(sparkClusterSpec.getWorker().getInstances());
            updateStatus(sparkClusterSpec, "scaled");
        } else {
            log.info("recreating cluster {}", existingCluster.getName());
            KubernetesResourceList list = getDeployer().getResourceList(sparkClusterSpec);
            try {
                kubernetesClient.resourceList(list).inNamespace(namespace).createOrReplace();
            } catch (Exception e) {
                log.warn("deleting and creating cluster {}", existingCluster.getName());
                kubernetesClient.resourceList(list).inNamespace(namespace).delete();
                kubernetesClient.resourceList(list).inNamespace(namespace).createOrReplace();
            }
            getClusters().put(sparkClusterSpec);
            updateStatus(sparkClusterSpec, "ready");
        }
    }


    @Override
    public void init(EventSourceManager eventSourceManager) {
        ResourceController.super.init(eventSourceManager);
        log.info("Spark Cluster operator default spark image = {}", Constants.getDefaultSparkImage());

    }

    private MetricsHelper metrics;
    private RunningClusters clusters;
    private KubernetesSparkClusterDeployer deployer;

    public void doAdd(SparkCluster sparkClusterSpec) {
        KubernetesResourceList list = getDeployer().getResourceList(sparkClusterSpec);
        kubernetesClient.resourceList(list).inNamespace(namespace).createOrReplace();
        getClusters().put(sparkClusterSpec);
//        updateStatus(cluster, "ready");

    }

    public KubernetesSparkClusterDeployer getDeployer() {
        if (this.deployer == null) {
            this.deployer = new KubernetesSparkClusterDeployer(kubernetesClient, "SparkCluster", "radanalytics.io", namespace);
        }
        return deployer;
    }

    private RunningClusters getClusters() {
        if (null == clusters) {
            clusters = new RunningClusters(namespace);
        }
        return clusters;
    }

    private void updateStatus(SparkCluster cluster, String state) {
        for (int i = 0; i < 3; i++) {
            try {
                setCRStatus(state, cluster.getNamespace(), cluster.getName());
                break;
            } catch (Exception e) {
                log.warn("failed to update status {} for {} in {}", state, cluster.getName(), cluster.getNamespace());
                try {
                    Thread.sleep(500);
                } catch (Exception t) {
                }
            }
        }
    }

    //TOD check it out
    protected void setCRStatus(String status, String namespace, String sparkClusterName) {

        CustomResourceDefinitionContext sparkClusterCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkClusterResource.class);
        SparkClusterStatus sparkClusterStatus = new SparkClusterStatus(status, new Date());

//        var customResourceClient =
//                kubernetesClient.customResources(SparkClusterResource.class);
//        SparkClusterResource sparkClusterResource = customResourceClient
//                .inNamespace(namespace)
//                .withName(sparkClusterName)
//                .get();
//        if (sparkClusterResource != null) {
//            sparkClusterResource.setStatus(sparkClusterStatus);
//            customResourceClient.inNamespace(namespace).withName(sparkClusterName).updateStatus(sparkClusterResource);
//        }


        String statusJson;
        try{
            statusJson = mapper.writeValueAsString(sparkClusterStatus);

            JSONObject sparkCluster = new JSONObject(kubernetesClient.customResource(sparkClusterCustomResource)
                    .get(namespace, sparkClusterName));
             sparkCluster.put("status", statusJson);
            System.out.println("asdasdasd");
            kubernetesClient.customResource(sparkClusterCustomResource)
                    .edit(namespace, sparkClusterName, sparkCluster);
//            kubernetesClient.customResource(sparkClusterCustomResource).inNamespace(namespace).withName(sparkClusterName)
//                    .updateStatus(statusJson);


        } catch (JsonProcessingException e) {
            log.error("Unable to convert the satus object into json", e);
        } catch (IOException e) {
            log.error("Unable to update status", e);
        }

    }

}
