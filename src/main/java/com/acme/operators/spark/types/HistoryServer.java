
package com.acme.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "type",
    "sharedVolume",
    "remoteURI"
})
@RegisterForReflection
public class HistoryServer {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private Type type = Type.fromValue("sharedVolume");
    @JsonProperty("sharedVolume")
    private SharedVolume sharedVolume;
    /**
     * s3 bucket or hdfs path
     * 
     */
    @JsonProperty("remoteURI")
    @JsonPropertyDescription("s3 bucket or hdfs path")
    private String remoteURI;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("sharedVolume")
    public SharedVolume getSharedVolume() {
        return sharedVolume;
    }

    @JsonProperty("sharedVolume")
    public void setSharedVolume(SharedVolume sharedVolume) {
        this.sharedVolume = sharedVolume;
    }

    /**
     * s3 bucket or hdfs path
     * 
     */
    @JsonProperty("remoteURI")
    public String getRemoteURI() {
        return remoteURI;
    }

    /**
     * s3 bucket or hdfs path
     * 
     */
    @JsonProperty("remoteURI")
    public void setRemoteURI(String remoteURI) {
        this.remoteURI = remoteURI;
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
        sb.append(HistoryServer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("sharedVolume");
        sb.append('=');
        sb.append(((this.sharedVolume == null)?"<null>":this.sharedVolume));
        sb.append(',');
        sb.append("remoteURI");
        sb.append('=');
        sb.append(((this.remoteURI == null)?"<null>":this.remoteURI));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.remoteURI == null)? 0 :this.remoteURI.hashCode()));
        result = ((result* 31)+((this.sharedVolume == null)? 0 :this.sharedVolume.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HistoryServer) == false) {
            return false;
        }
        HistoryServer rhs = ((HistoryServer) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.remoteURI == rhs.remoteURI)||((this.remoteURI!= null)&&this.remoteURI.equals(rhs.remoteURI))))&&((this.sharedVolume == rhs.sharedVolume)||((this.sharedVolume!= null)&&this.sharedVolume.equals(rhs.sharedVolume))));
    }

    public enum Type {

        sharedVolume("sharedVolume"),
        remoteStorage("remoteStorage");
        private final String value;
        private final static Map<String, Type> CONSTANTS = new HashMap<String, Type>();

        static {
            for (Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Type fromValue(String value) {
            Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
