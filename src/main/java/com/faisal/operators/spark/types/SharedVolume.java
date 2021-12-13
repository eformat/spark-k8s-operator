
package com.faisal.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "size",
    "mountPath",
    "matchLabels"
})
@RegisterForReflection
public class SharedVolume {

    @JsonProperty("size")
    private String size = "0.3Gi";
    @JsonProperty("mountPath")
    private String mountPath = "/history/spark-events";
    @JsonProperty("matchLabels")
    private Map<String, String> matchLabels;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    @JsonProperty("matchLabels")
    public Map<String, String> getMatchLabels() {
        return matchLabels;
    }

    @JsonProperty("matchLabels")
    public void setMatchLabels(Map<String, String> matchLabels) {
        this.matchLabels = matchLabels;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SharedVolume.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("mountPath");
        sb.append('=');
        sb.append(((this.mountPath == null)?"<null>":this.mountPath));
        sb.append(',');
        sb.append("matchLabels");
        sb.append('=');
        sb.append(((this.matchLabels == null)?"<null>":this.matchLabels));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.mountPath == null)? 0 :this.mountPath.hashCode()));
        result = ((result* 31)+((this.matchLabels == null)? 0 :this.matchLabels.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.size == null)? 0 :this.size.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SharedVolume) == false) {
            return false;
        }
        SharedVolume rhs = ((SharedVolume) other);
        return (((((this.mountPath == rhs.mountPath)||((this.mountPath!= null)&&this.mountPath.equals(rhs.mountPath)))&&((this.matchLabels == rhs.matchLabels)||((this.matchLabels!= null)&&this.matchLabels.equals(rhs.matchLabels))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.size == rhs.size)||((this.size!= null)&&this.size.equals(rhs.size))));
    }

}
