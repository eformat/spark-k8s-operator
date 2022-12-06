package com.acme.operators.spark.historyserver;

import com.acme.operators.spark.cluster.SparkCluster;
import com.acme.operators.spark.types.HistoryServer;

public class HistoryServerHelper {

    public static boolean needsVolume(SparkHistoryServer hs) {
        return HistoryServer.Type.sharedVolume.value().equals(hs.getType().value());
    }

    public static boolean needsVolume(SparkCluster cluster) {
        return null != cluster.getHistoryServer() && HistoryServer.Type.sharedVolume.value().equals(cluster.getHistoryServer().getType().value());
    }
}
