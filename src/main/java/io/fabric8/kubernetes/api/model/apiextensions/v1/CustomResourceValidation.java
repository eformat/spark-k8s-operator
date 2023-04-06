//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.fabric8.kubernetes.api.model.apiextensions.v1;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"apiVersion", "kind", "metadata", "openAPIV3Schema"})
public class CustomResourceValidation implements KubernetesResource {
    @JsonProperty("openAPIV3Schema")
    private JSONSchemaProps openAPIV3Schema;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CustomResourceValidation() {
    }

    public CustomResourceValidation(JSONSchemaProps openAPIV3Schema) {
        this.openAPIV3Schema = openAPIV3Schema;
    }

    @JsonProperty("openAPIV3Schema")
    public JSONSchemaProps getOpenAPIV3Schema() {
        return this.openAPIV3Schema;
    }

    @JsonProperty("openAPIV3Schema")
    public void setOpenAPIV3Schema(JSONSchemaProps openAPIV3Schema) {
        this.openAPIV3Schema = openAPIV3Schema;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        return "CustomResourceValidation(openAPIV3Schema=" + this.getOpenAPIV3Schema() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomResourceValidation)) {
            return false;
        } else {
            CustomResourceValidation other = (CustomResourceValidation)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$openAPIV3Schema = this.getOpenAPIV3Schema();
                Object other$openAPIV3Schema = other.getOpenAPIV3Schema();
                if (this$openAPIV3Schema == null) {
                    if (other$openAPIV3Schema != null) {
                        return false;
                    }
                } else if (!this$openAPIV3Schema.equals(other$openAPIV3Schema)) {
                    return false;
                }

                Object this$additionalProperties = this.getAdditionalProperties();
                Object other$additionalProperties = other.getAdditionalProperties();
                if (this$additionalProperties == null) {
                    if (other$additionalProperties != null) {
                        return false;
                    }
                } else if (!this$additionalProperties.equals(other$additionalProperties)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CustomResourceValidation;
    }

    public int hashCode() {
        int result = 1;
        Object $openAPIV3Schema = this.getOpenAPIV3Schema();
        result = result * 59 + ($openAPIV3Schema == null ? 43 : $openAPIV3Schema.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * 59 + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }
}
