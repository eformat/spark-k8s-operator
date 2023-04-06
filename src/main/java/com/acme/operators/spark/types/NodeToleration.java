
package com.acme.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "operator",
    "value",
    "effect",
    "tolerationSeconds"
})
@RegisterForReflection
public class NodeToleration {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("operator")
    private String operator;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    private String value;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("effect")
    private String effect;
    @JsonProperty("tolerationSeconds")
    private Integer tolerationSeconds = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("effect")
    public String getEffect() {
        return effect;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("effect")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @JsonProperty("tolerationSeconds")
    public Integer getTolerationSeconds() {
        return tolerationSeconds;
    }

    @JsonProperty("tolerationSeconds")
    public void setTolerationSeconds(Integer tolerationSeconds) {
        this.tolerationSeconds = tolerationSeconds;
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
        sb.append(NodeToleration.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("operator");
        sb.append('=');
        sb.append(((this.operator == null)?"<null>":this.operator));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        sb.append("effect");
        sb.append('=');
        sb.append(((this.effect == null)?"<null>":this.effect));
        sb.append(',');
        sb.append("tolerationSeconds");
        sb.append('=');
        sb.append(((this.tolerationSeconds == null)?"<null>":this.tolerationSeconds));
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
        result = ((result* 31)+((this.effect == null)? 0 :this.effect.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        result = ((result* 31)+((this.tolerationSeconds == null)? 0 :this.tolerationSeconds.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        result = ((result* 31)+((this.operator == null)? 0 :this.operator.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NodeToleration) == false) {
            return false;
        }
        NodeToleration rhs = ((NodeToleration) other);
        return (((((((this.effect == rhs.effect)||((this.effect!= null)&&this.effect.equals(rhs.effect)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))))&&((this.tolerationSeconds == rhs.tolerationSeconds)||((this.tolerationSeconds!= null)&&this.tolerationSeconds.equals(rhs.tolerationSeconds))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))))&&((this.operator == rhs.operator)||((this.operator!= null)&&this.operator.equals(rhs.operator))));
    }

}
