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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"apiVersion", "kind", "metadata", "additionalPrinterColumns", "deprecated", "deprecationWarning", "name", "schema", "served", "storage", "subresources"})
public class CustomResourceDefinitionVersion implements KubernetesResource {
    @JsonProperty("additionalPrinterColumns")
    @JsonInclude(Include.NON_EMPTY)
    private List<CustomResourceColumnDefinition> additionalPrinterColumns = new ArrayList();
    @JsonProperty("deprecated")
    private Boolean deprecated;
    @JsonProperty("deprecationWarning")
    private String deprecationWarning;
    @JsonProperty("name")
    private String name;
    @JsonProperty("schema")
    private CustomResourceValidation schema;
    @JsonProperty("served")
    private Boolean served;
    @JsonProperty("storage")
    private Boolean storage;
    @JsonProperty("subresources")
    private CustomResourceSubresources subresources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CustomResourceDefinitionVersion() {
    }

    public CustomResourceDefinitionVersion(List<CustomResourceColumnDefinition> additionalPrinterColumns, Boolean deprecated, String deprecationWarning, String name, CustomResourceValidation schema, Boolean served, Boolean storage, CustomResourceSubresources subresources) {
        this.additionalPrinterColumns = additionalPrinterColumns;
        this.deprecated = deprecated;
        this.deprecationWarning = deprecationWarning;
        this.name = name;
        this.schema = schema;
        this.served = served;
        this.storage = storage;
        this.subresources = subresources;
    }

    @JsonProperty("additionalPrinterColumns")
    public List<CustomResourceColumnDefinition> getAdditionalPrinterColumns() {
        return this.additionalPrinterColumns;
    }

    @JsonProperty("additionalPrinterColumns")
    public void setAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
        this.additionalPrinterColumns = additionalPrinterColumns;
    }

    @JsonProperty("deprecated")
    public Boolean getDeprecated() {
        return this.deprecated;
    }

    @JsonProperty("deprecated")
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    @JsonProperty("deprecationWarning")
    public String getDeprecationWarning() {
        return this.deprecationWarning;
    }

    @JsonProperty("deprecationWarning")
    public void setDeprecationWarning(String deprecationWarning) {
        this.deprecationWarning = deprecationWarning;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("schema")
    public CustomResourceValidation getSchema() {
        return this.schema;
    }

    @JsonProperty("schema")
    public void setSchema(CustomResourceValidation schema) {
        this.schema = schema;
    }

    @JsonProperty("served")
    public Boolean getServed() {
        return this.served;
    }

    @JsonProperty("served")
    public void setServed(Boolean served) {
        this.served = served;
    }

    @JsonProperty("storage")
    public Boolean getStorage() {
        return this.storage;
    }

    @JsonProperty("storage")
    public void setStorage(Boolean storage) {
        this.storage = storage;
    }

    @JsonProperty("subresources")
    public CustomResourceSubresources getSubresources() {
        return this.subresources;
    }

    @JsonProperty("subresources")
    public void setSubresources(CustomResourceSubresources subresources) {
        this.subresources = subresources;
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
        return "CustomResourceDefinitionVersion(additionalPrinterColumns=" + this.getAdditionalPrinterColumns() + ", deprecated=" + this.getDeprecated() + ", deprecationWarning=" + this.getDeprecationWarning() + ", name=" + this.getName() + ", schema=" + this.getSchema() + ", served=" + this.getServed() + ", storage=" + this.getStorage() + ", subresources=" + this.getSubresources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomResourceDefinitionVersion)) {
            return false;
        } else {
            CustomResourceDefinitionVersion other = (CustomResourceDefinitionVersion)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$deprecated = this.getDeprecated();
                    Object other$deprecated = other.getDeprecated();
                    if (this$deprecated == null) {
                        if (other$deprecated == null) {
                            break label119;
                        }
                    } else if (this$deprecated.equals(other$deprecated)) {
                        break label119;
                    }

                    return false;
                }

                Object this$served = this.getServed();
                Object other$served = other.getServed();
                if (this$served == null) {
                    if (other$served != null) {
                        return false;
                    }
                } else if (!this$served.equals(other$served)) {
                    return false;
                }

                label105: {
                    Object this$storage = this.getStorage();
                    Object other$storage = other.getStorage();
                    if (this$storage == null) {
                        if (other$storage == null) {
                            break label105;
                        }
                    } else if (this$storage.equals(other$storage)) {
                        break label105;
                    }

                    return false;
                }

                Object this$additionalPrinterColumns = this.getAdditionalPrinterColumns();
                Object other$additionalPrinterColumns = other.getAdditionalPrinterColumns();
                if (this$additionalPrinterColumns == null) {
                    if (other$additionalPrinterColumns != null) {
                        return false;
                    }
                } else if (!this$additionalPrinterColumns.equals(other$additionalPrinterColumns)) {
                    return false;
                }

                label91: {
                    Object this$deprecationWarning = this.getDeprecationWarning();
                    Object other$deprecationWarning = other.getDeprecationWarning();
                    if (this$deprecationWarning == null) {
                        if (other$deprecationWarning == null) {
                            break label91;
                        }
                    } else if (this$deprecationWarning.equals(other$deprecationWarning)) {
                        break label91;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                label77: {
                    Object this$schema = this.getSchema();
                    Object other$schema = other.getSchema();
                    if (this$schema == null) {
                        if (other$schema == null) {
                            break label77;
                        }
                    } else if (this$schema.equals(other$schema)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$subresources = this.getSubresources();
                    Object other$subresources = other.getSubresources();
                    if (this$subresources == null) {
                        if (other$subresources == null) {
                            break label70;
                        }
                    } else if (this$subresources.equals(other$subresources)) {
                        break label70;
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
        return other instanceof CustomResourceDefinitionVersion;
    }

    public int hashCode() {
        int result = 1;
        Object $deprecated = this.getDeprecated();
        result = result * 59 + ($deprecated == null ? 43 : $deprecated.hashCode());
        Object $served = this.getServed();
        result = result * 59 + ($served == null ? 43 : $served.hashCode());
        Object $storage = this.getStorage();
        result = result * 59 + ($storage == null ? 43 : $storage.hashCode());
        Object $additionalPrinterColumns = this.getAdditionalPrinterColumns();
        result = result * 59 + ($additionalPrinterColumns == null ? 43 : $additionalPrinterColumns.hashCode());
        Object $deprecationWarning = this.getDeprecationWarning();
        result = result * 59 + ($deprecationWarning == null ? 43 : $deprecationWarning.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $schema = this.getSchema();
        result = result * 59 + ($schema == null ? 43 : $schema.hashCode());
        Object $subresources = this.getSubresources();
        result = result * 59 + ($subresources == null ? 43 : $subresources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * 59 + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }
}
