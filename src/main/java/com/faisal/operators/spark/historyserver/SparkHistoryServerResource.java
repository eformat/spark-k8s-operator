package com.faisal.operators.spark.historyserver;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.*;

@Group("radanalytics.io")
@Version("v1")
@ShortNames("shs")
@Kind("SparkHistoryServer")
@Plural("sparkhistoryservers")
@Singular("sparkhistoryserver")
public class SparkHistoryServerResource extends CustomResource<SparkHistoryServer, SparkHistoryServerStatus> implements Namespaced {

    private SparkHistoryServer spec;
    private SparkHistoryServerStatus status;

    public SparkHistoryServerResource() {
    }

    @Override
    public SparkHistoryServer getSpec() {
        return spec;
    }

    @Override
    public void setSpec(SparkHistoryServer spec) {
        this.spec = spec;
    }

    @Override
    public SparkHistoryServerStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(SparkHistoryServerStatus status) {
        this.status = status;
    }
}
