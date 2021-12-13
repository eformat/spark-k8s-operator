package com.faisal.operators.spark.historyserver;

import com.faisal.operators.spark.cluster.SparkCluster;
import com.faisal.operators.spark.types.HistoryServer;
import com.faisal.operators.spark.types.SparkHistoryServer;

public class HistoryServerHelper {

    public static boolean needsVolume(SparkHistoryServer hs) {
        return HistoryServer.Type.sharedVolume.value().equals(hs.getType().value());
    }

    public static boolean needsVolume(SparkCluster cluster) {
        return null != cluster.getHistoryServer() && HistoryServer.Type.sharedVolume.value().equals(cluster.getHistoryServer().getType().value());
    }
}
