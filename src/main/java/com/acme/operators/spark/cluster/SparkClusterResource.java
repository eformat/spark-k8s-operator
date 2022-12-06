package com.acme.operators.spark.cluster;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.*;


@Group("radanalytics.io")
@Version("v1")
@ShortNames("sc")
@Kind("SparkCluster")
@Plural("sparkclusters")
@Singular("sparkcluster")
public class SparkClusterResource extends CustomResource<SparkCluster, SparkClusterStatus> implements Namespaced {

    private SparkCluster spec;
    private SparkClusterStatus status;

    public SparkClusterResource(){
    }

    @Override
    public SparkCluster getSpec() {
        return spec;
    }

    @Override
    public void setSpec(SparkCluster spec) {
        this.spec = spec;
    }

    @Override
    public SparkClusterStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(SparkClusterStatus status) {
        this.status = status;
    }
}
