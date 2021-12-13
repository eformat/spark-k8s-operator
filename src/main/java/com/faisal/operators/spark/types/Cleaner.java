
package com.faisal.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "interval",
    "maxAge"
})
@RegisterForReflection
public class Cleaner {

    /**
     * Specifies whether the History Server should periodically clean up event logs from storage.
     * 
     */
    @JsonProperty("enabled")
    @JsonPropertyDescription("Specifies whether the History Server should periodically clean up event logs from storage.")
    private Boolean enabled = false;
    /**
     * How often (days) the filesystem job history cleaner checks for files to delete. Files are only deleted if they are older than spark.history.fs.cleaner.maxAge
     * 
     */
    @JsonProperty("interval")
    @JsonPropertyDescription("How often (days) the filesystem job history cleaner checks for files to delete. Files are only deleted if they are older than spark.history.fs.cleaner.maxAge")
    private Integer interval = 1;
    /**
     * # of days, job history files older than this will be deleted when the filesystem history cleaner runs.
     * 
     */
    @JsonProperty("maxAge")
    @JsonPropertyDescription("# of days, job history files older than this will be deleted when the filesystem history cleaner runs.")
    private Integer maxAge = 7;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Specifies whether the History Server should periodically clean up event logs from storage.
     * 
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Specifies whether the History Server should periodically clean up event logs from storage.
     * 
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * How often (days) the filesystem job history cleaner checks for files to delete. Files are only deleted if they are older than spark.history.fs.cleaner.maxAge
     * 
     */
    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    /**
     * How often (days) the filesystem job history cleaner checks for files to delete. Files are only deleted if they are older than spark.history.fs.cleaner.maxAge
     * 
     */
    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     * # of days, job history files older than this will be deleted when the filesystem history cleaner runs.
     * 
     */
    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     * # of days, job history files older than this will be deleted when the filesystem history cleaner runs.
     * 
     */
    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
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
        sb.append(Cleaner.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("enabled");
        sb.append('=');
        sb.append(((this.enabled == null)?"<null>":this.enabled));
        sb.append(',');
        sb.append("interval");
        sb.append('=');
        sb.append(((this.interval == null)?"<null>":this.interval));
        sb.append(',');
        sb.append("maxAge");
        sb.append('=');
        sb.append(((this.maxAge == null)?"<null>":this.maxAge));
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
        result = ((result* 31)+((this.interval == null)? 0 :this.interval.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.maxAge == null)? 0 :this.maxAge.hashCode()));
        result = ((result* 31)+((this.enabled == null)? 0 :this.enabled.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cleaner) == false) {
            return false;
        }
        Cleaner rhs = ((Cleaner) other);
        return (((((this.interval == rhs.interval)||((this.interval!= null)&&this.interval.equals(rhs.interval)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.maxAge == rhs.maxAge)||((this.maxAge!= null)&&this.maxAge.equals(rhs.maxAge))))&&((this.enabled == rhs.enabled)||((this.enabled!= null)&&this.enabled.equals(rhs.enabled))));
    }

}
