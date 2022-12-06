package com.acme.operators.spark.historyserver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "state",
        "lastTransitionTime"})

public class SparkHistoryServerStatus {

    @JsonProperty("state")
    private String state;

    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;

    private static String toDateString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(date);
    }

    public SparkHistoryServerStatus() {
        this.state = "initial";
        this.lastTransitionTime = toDateString(new Date());
    }

    public SparkHistoryServerStatus(String state, Date dt) {
        this.state = state;
        this.lastTransitionTime = toDateString(dt);
    }

    public void setState(String s) {
        this.state = s;
    }

    public String getState() {
        return this.state;
    }

    public void setLastTransitionTime(Date dt) {
        this.lastTransitionTime = toDateString(dt);
    }

    public String getLastTransitionTime() {
        return this.lastTransitionTime;
    }

    public String toString() {
        return "SparkHistoryServerStatus{ state=" + this.state + " lastTransitionTime=" + this.lastTransitionTime + "}";
    }
}
