//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package io.fabric8.kubernetes.api.model.apiextensions.v1;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.PackageSuffix;
import io.fabric8.kubernetes.model.annotation.Version;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"apiVersion", "kind", "metadata", "spec", "status"})
@Version("v1")
@Group("apiextensions.k8s.io")
@PackageSuffix(".apiextensions.v1")
public class CustomResourceDefinition implements HasMetadata {
    @JsonProperty("apiVersion")
    private String apiVersion = "apiextensions.k8s.io/v1";
    @JsonProperty("kind")
    private String kind = "CustomResourceDefinition";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private CustomResourceDefinitionSpec spec;
    @JsonProperty("status")
    private CustomResourceDefinitionStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CustomResourceDefinition() {
    }

    public CustomResourceDefinition(String apiVersion, String kind, ObjectMeta metadata, CustomResourceDefinitionSpec spec, CustomResourceDefinitionStatus status) {
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return this.apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("kind")
    public String getKind() {
        return this.kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return this.metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("spec")
    public CustomResourceDefinitionSpec getSpec() {
        return this.spec;
    }

    @JsonProperty("spec")
    public void setSpec(CustomResourceDefinitionSpec spec) {
        this.spec = spec;
    }

    @JsonProperty("status")
    public CustomResourceDefinitionStatus getStatus() {
        return this.status;
    }

    @JsonProperty("status")
    public void setStatus(CustomResourceDefinitionStatus status) {
        this.status = status;
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
        return "CustomResourceDefinition(apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", spec=" + this.getSpec() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomResourceDefinition)) {
            return false;
        } else {
            CustomResourceDefinition other = (CustomResourceDefinition)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$apiVersion = this.getApiVersion();
                Object other$apiVersion = other.getApiVersion();
                if (this$apiVersion == null) {
                    if (other$apiVersion != null) {
                        return false;
                    }
                } else if (!this$apiVersion.equals(other$apiVersion)) {
                    return false;
                }

                Object this$kind = this.getKind();
                Object other$kind = other.getKind();
                if (this$kind == null) {
                    if (other$kind != null) {
                        return false;
                    }
                } else if (!this$kind.equals(other$kind)) {
                    return false;
                }

                Object this$metadata = this.getMetadata();
                Object other$metadata = other.getMetadata();
                if (this$metadata == null) {
                    if (other$metadata != null) {
                        return false;
                    }
                } else if (!this$metadata.equals(other$metadata)) {
                    return false;
                }

                label62: {
                    Object this$spec = this.getSpec();
                    Object other$spec = other.getSpec();
                    if (this$spec == null) {
                        if (other$spec == null) {
                            break label62;
                        }
                    } else if (this$spec.equals(other$spec)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label55;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label55;
                    }

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
        return other instanceof CustomResourceDefinition;
    }

    public int hashCode() {
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * 59 + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * 59 + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
        Object $spec = this.getSpec();
        result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * 59 + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }
}
