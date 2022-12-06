package com.acme.operators.spark.historyserver;

import com.acme.operators.spark.cluster.SparkClusterController;
import com.faisal.operators.spark.cluster.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.javaoperatorsdk.operator.api.*;
import io.javaoperatorsdk.operator.processing.event.EventSourceManager;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

import static io.javaoperatorsdk.operator.api.Controller.WATCH_CURRENT_NAMESPACE;

@Controller(namespaces = WATCH_CURRENT_NAMESPACE)
public class SparkHistoryServerController implements ResourceController<SparkHistoryServerResource>  {

    private final KubernetesClient kubernetesClient;

    ObjectMapper mapper = new ObjectMapper();

    public SparkHistoryServerController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @ConfigProperty(name = "quarkus.kubernetes-client.namespace")
    String namespace;

    private final Logger log = LoggerFactory.getLogger(SparkClusterController.class);


    @Override
    public DeleteControl deleteResource(SparkHistoryServerResource sparkHistoryServerResource, Context<SparkHistoryServerResource> context) {
        final var spec = sparkHistoryServerResource.getSpec();

        log.info("Received {} ", sparkHistoryServerResource);

        String namespace = sparkHistoryServerResource.getMetadata().getNamespace();
        log.info("Received NS {} ", namespace);

        CustomResourceDefinitionContext sparkHistoryServerCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkHistoryServerResource.class);

        Map<String, Object> sparkHistoryServersWithName = kubernetesClient.customResource(sparkHistoryServerCustomResource)
                .get(namespace, sparkHistoryServerResource.getMetadata().getName());
        SparkHistoryServer sparkHistoryServerSpec = mapper.convertValue(sparkHistoryServersWithName.get("spec"), SparkHistoryServer.class);

        String name = sparkHistoryServerSpec.getName();


//        updateStatus(sparkHistoryServerSpec, "deleted");
        kubernetesClient.services().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.replicationControllers().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.pods().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        kubernetesClient.persistentVolumeClaims().inNamespace(namespace).withLabels(getDeployer().getDefaultLabels(name)).delete();
        return DeleteControl.DEFAULT_DELETE;

    }

    private KubernetesHistoryServerDeployer deployer;


    public KubernetesHistoryServerDeployer getDeployer() {
        if (this.deployer == null) {
            this.deployer = new KubernetesHistoryServerDeployer("SparkHistoryServer", "radanalytics.io");
        }
        return deployer;
    }

    @Override
    public UpdateControl<SparkHistoryServerResource> createOrUpdateResource(SparkHistoryServerResource sparkHistoryServerResource, Context<SparkHistoryServerResource> context) {
        final var spec = sparkHistoryServerResource.getSpec();

        log.info("Received {} ", sparkHistoryServerResource);

        String namespace = sparkHistoryServerResource.getMetadata().getNamespace();
        log.info("Received NS {} ", namespace);

        CustomResourceDefinitionContext sparkClusterCustomResource = CustomResourceDefinitionContext.fromCustomResourceType(SparkHistoryServerResource.class);

        Map<String, Object> sparkHistoryServersWithName = kubernetesClient.customResource(sparkClusterCustomResource).get(namespace, sparkHistoryServerResource.getMetadata().getName());


//        Map<String, Object> cr = kubernetesClient.customResource(sparkClusterCustomResource).get(namespace, );
//        SparkCluster sparkHistoryServerSpec = mapper.convertValue(sparkHistoryServersWithName.get("spec"), SparkCluster.class);

        var replicationController =
                kubernetesClient.replicationControllers().inNamespace(namespace).withName(sparkHistoryServerResource.getMetadata().getName()).get();

        SparkHistoryServer sparkHistoryServerSpec = mapper.convertValue(sparkHistoryServersWithName.get("spec"), SparkHistoryServer.class);
        if (sparkHistoryServerSpec.getName() == null || sparkHistoryServerSpec.getName().isEmpty()) {
            sparkHistoryServerSpec.setName(sparkHistoryServerResource.getMetadata().getName());
            sparkHistoryServerSpec.setNamespace(sparkHistoryServerResource.getMetadata().getNamespace());
        }

        if (replicationController == null) {
            log.info("its a new request for history server");

            //TODO add ingress for the history server
            KubernetesResourceList list = deployer.getResourceList(spec, namespace, false);


            kubernetesClient.resourceList(list).inNamespace(namespace).createOrReplace();

            sparkHistoryServerResource.setStatus(new SparkHistoryServerStatus("ready", new Date()));
            return UpdateControl.updateStatusSubResource(sparkHistoryServerResource);

        } else {
            log.info("Updayes in Hisotry SErver resoirces is not supported");
            return UpdateControl.noUpdate();
        }

    }

    @Override
    public void init(EventSourceManager eventSourceManager) {
        ResourceController.super.init(eventSourceManager);
        log.info("Spark Hitory SErver operatorstarted");
    }
}
