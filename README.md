# spark-k8s-operator

A Quarkus controller to manage radanalytics.io/v1 SparkCluster's

```yaml
apiVersion: radanalytics.io/v1
kind: SparkCluster
metadata:
  name: spark
spec:
  master:
    command: []
    commandArgs: []
    cpuLimit: 500m
    cpuRequest: 100m
    instances: 1
    memoryLimit: 2Gi
    memoryRequest: 2Gi
  metrics: true
  customImage: 'quay.io/eformat/spark-rad:3.3.0'
  sparkWebUI: true
  env:
    - name: SPARK_METRICS_ON
      value: prometheus
  downloadData: []
  mavenRepositories: []
  mavenDependencies: []
  sparkConfiguration: []
  nodeTolerations: []
  worker:
    command: []
    commandArgs: []
    cpuLimit: 250m
    cpuRequest: 250m
    instances: 1
    memoryLimit: 4Gi
    memoryRequest: 4Gi
```
