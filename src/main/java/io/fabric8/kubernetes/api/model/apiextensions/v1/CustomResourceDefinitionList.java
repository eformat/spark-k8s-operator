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
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.PackageSuffix;
import io.fabric8.kubernetes.model.annotation.Version;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"apiVersion", "kind", "metadata", "items"})
@Version("v1")
@Group("apiextensions.k8s.io")
@PackageSuffix(".apiextensions.v1")
public class CustomResourceDefinitionList implements KubernetesResource, KubernetesResourceList<CustomResourceDefinition> {
    @JsonProperty("apiVersion")
    private String apiVersion = "apiextensions.k8s.io/v1";
    @JsonProperty("items")
    private List<CustomResourceDefinition> items = new ArrayList();
    @JsonProperty("kind")
    private String kind = "CustomResourceDefinitionList";
    @JsonProperty("metadata")
    private ListMeta metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CustomResourceDefinitionList() {
    }

    public CustomResourceDefinitionList(String apiVersion, List<CustomResourceDefinition> items, String kind, ListMeta metadata) {
        this.apiVersion = apiVersion;
        this.items = items;
        this.kind = kind;
        this.metadata = metadata;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return this.apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("items")
    public List<CustomResourceDefinition> getItems() {
        return this.items;
    }

    @JsonProperty("items")
    public void setItems(List<CustomResourceDefinition> items) {
        this.items = items;
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
    public ListMeta getMetadata() {
        return this.metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ListMeta metadata) {
        this.metadata = metadata;
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
        return "CustomResourceDefinitionList(apiVersion=" + this.getApiVersion() + ", items=" + this.getItems() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomResourceDefinitionList)) {
            return false;
        } else {
            CustomResourceDefinitionList other = (CustomResourceDefinitionList)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$apiVersion = this.getApiVersion();
                    Object other$apiVersion = other.getApiVersion();
                    if (this$apiVersion == null) {
                        if (other$apiVersion == null) {
                            break label71;
                        }
                    } else if (this$apiVersion.equals(other$apiVersion)) {
                        break label71;
                    }

                    return false;
                }

                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                label57: {
                    Object this$kind = this.getKind();
                    Object other$kind = other.getKind();
                    if (this$kind == null) {
                        if (other$kind == null) {
                            break label57;
                        }
                    } else if (this$kind.equals(other$kind)) {
                        break label57;
                    }

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

                Object this$additionalProperties = this.getAdditionalProperties();
                Object other$additionalProperties = other.getAdditionalProperties();
                if (this$additionalProperties == null) {
                    if (other$additionalProperties == null) {
                        return true;
                    }
                } else if (this$additionalProperties.equals(other$additionalProperties)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CustomResourceDefinitionList;
    }

    public int hashCode() {
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * 59 + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        Object $kind = this.getKind();
        result = result * 59 + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * 59 + ($metadata == null ? 43 : $metadata.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * 59 + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }
}
