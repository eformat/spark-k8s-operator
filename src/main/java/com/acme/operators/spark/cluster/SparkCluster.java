package com.acme.operators.spark.cluster;

import com.acme.operators.EntityInfo;
import com.acme.operators.spark.types.*;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "master",
        "worker",
        "nodeTolerations",
        "mavenDependencies",
        "mavenRepositories",
        "customImage",
        "customInitContainerImage",
        "metrics",
        "sparkWebUI",
        "sparkConfigurationMap",
        "env",
        "sparkConfiguration",
        "labels",
        "historyServer",
        "downloadData"
})
public class SparkCluster extends EntityInfo {


    @JsonProperty("master")
    private Master master;
    @JsonProperty("worker")
    private Worker worker;
    @JsonProperty("nodeTolerations")
    private List<NodeToleration> nodeTolerations = new ArrayList<NodeToleration>();
    @JsonProperty("mavenDependencies")
    private List<java.lang.String> mavenDependencies = new ArrayList<java.lang.String>();
    @JsonProperty("mavenRepositories")
    private List<java.lang.String> mavenRepositories = new ArrayList<java.lang.String>();
    @JsonProperty("customImage")
    private java.lang.String customImage;
    @JsonProperty("customInitContainerImage")
    private java.lang.String customInitContainerImage;
    @JsonProperty("metrics")
    private Boolean metrics = false;
    @JsonProperty("sparkWebUI")
    private Boolean sparkWebUI = true;
    @JsonProperty("sparkConfigurationMap")
    private java.lang.String sparkConfigurationMap;
    @JsonProperty("env")
    private List<Env> env = new ArrayList<Env>();
    @JsonProperty("sparkConfiguration")
    private List<SparkConfiguration> sparkConfiguration = new ArrayList<SparkConfiguration>();
    @JsonProperty("labels")
    private Map<String, String> labels;
    @JsonProperty("historyServer")
    private HistoryServer historyServer;
    @JsonProperty("downloadData")
    private List<DownloadDatum> downloadData = new ArrayList<DownloadDatum>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("master")
    public Master getMaster() {
        return master;
    }

    @JsonProperty("master")
    public void setMaster(Master master) {
        this.master = master;
    }

    @JsonProperty("worker")
    public Worker getWorker() {
        return worker;
    }

    @JsonProperty("worker")
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @JsonProperty("nodeTolerations")
    public List<NodeToleration> getNodeTolerations() {
        return nodeTolerations;
    }

    @JsonProperty("nodeTolerations")
    public void setNodeTolerations(List<NodeToleration> nodeTolerations) {
        this.nodeTolerations = nodeTolerations;
    }

    @JsonProperty("mavenDependencies")
    public List<java.lang.String> getMavenDependencies() {
        return mavenDependencies;
    }

    @JsonProperty("mavenDependencies")
    public void setMavenDependencies(List<java.lang.String> mavenDependencies) {
        this.mavenDependencies = mavenDependencies;
    }

    @JsonProperty("mavenRepositories")
    public List<java.lang.String> getMavenRepositories() {
        return mavenRepositories;
    }

    @JsonProperty("mavenRepositories")
    public void setMavenRepositories(List<java.lang.String> mavenRepositories) {
        this.mavenRepositories = mavenRepositories;
    }

    @JsonProperty("customImage")
    public java.lang.String getCustomImage() {
        return customImage;
    }

    @JsonProperty("customImage")
    public void setCustomImage(java.lang.String customImage) {
        this.customImage = customImage;
    }

    @JsonProperty("customInitContainerImage")
    public java.lang.String getCustomInitContainerImage() {
        return customInitContainerImage;
    }

    @JsonProperty("customInitContainerImage")
    public void setCustomInitContainerImage(java.lang.String customInitContainerImage) {
        this.customInitContainerImage = customInitContainerImage;
    }

    @JsonProperty("metrics")
    public Boolean getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(Boolean metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("sparkWebUI")
    public Boolean getSparkWebUI() {
        return sparkWebUI;
    }

    @JsonProperty("sparkWebUI")
    public void setSparkWebUI(Boolean sparkWebUI) {
        this.sparkWebUI = sparkWebUI;
    }

    @JsonProperty("sparkConfigurationMap")
    public java.lang.String getSparkConfigurationMap() {
        return sparkConfigurationMap;
    }

    @JsonProperty("sparkConfigurationMap")
    public void setSparkConfigurationMap(java.lang.String sparkConfigurationMap) {
        this.sparkConfigurationMap = sparkConfigurationMap;
    }

    @JsonProperty("env")
    public List<Env> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<Env> env) {
        this.env = env;
    }

    @JsonProperty("sparkConfiguration")
    public List<SparkConfiguration> getSparkConfiguration() {
        return sparkConfiguration;
    }

    @JsonProperty("sparkConfiguration")
    public void setSparkConfiguration(List<SparkConfiguration> sparkConfiguration) {
        this.sparkConfiguration = sparkConfiguration;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("historyServer")
    public HistoryServer getHistoryServer() {
        return historyServer;
    }

    @JsonProperty("historyServer")
    public void setHistoryServer(HistoryServer historyServer) {
        this.historyServer = historyServer;
    }

    @JsonProperty("downloadData")
    public List<DownloadDatum> getDownloadData() {
        return downloadData;
    }

    @JsonProperty("downloadData")
    public void setDownloadData(List<DownloadDatum> downloadData) {
        this.downloadData = downloadData;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
