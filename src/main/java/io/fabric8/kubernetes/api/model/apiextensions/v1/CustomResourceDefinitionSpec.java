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
@JsonPropertyOrder({"apiVersion", "kind", "metadata", "conversion", "group", "names", "preserveUnknownFields", "scope", "versions"})
public class CustomResourceDefinitionSpec implements KubernetesResource {
    @JsonProperty("conversion")
    private CustomResourceConversion conversion;
    @JsonProperty("group")
    private String group;
    @JsonProperty("names")
    private CustomResourceDefinitionNames names;
    @JsonProperty("preserveUnknownFields")
    private Boolean preserveUnknownFields;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("versions")
    private List<CustomResourceDefinitionVersion> versions = new ArrayList();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap();

    public CustomResourceDefinitionSpec() {
    }

    public CustomResourceDefinitionSpec(CustomResourceConversion conversion, String group, CustomResourceDefinitionNames names, Boolean preserveUnknownFields, String scope, List<CustomResourceDefinitionVersion> versions) {
        this.conversion = conversion;
        this.group = group;
        this.names = names;
        this.preserveUnknownFields = preserveUnknownFields;
        this.scope = scope;
        this.versions = versions;
    }

    @JsonProperty("conversion")
    public CustomResourceConversion getConversion() {
        return this.conversion;
    }

    @JsonProperty("conversion")
    public void setConversion(CustomResourceConversion conversion) {
        this.conversion = conversion;
    }

    @JsonProperty("group")
    public String getGroup() {
        return this.group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("names")
    public CustomResourceDefinitionNames getNames() {
        return this.names;
    }

    @JsonProperty("names")
    public void setNames(CustomResourceDefinitionNames names) {
        this.names = names;
    }

    @JsonProperty("preserveUnknownFields")
    public Boolean getPreserveUnknownFields() {
        return this.preserveUnknownFields;
    }

    @JsonProperty("preserveUnknownFields")
    public void setPreserveUnknownFields(Boolean preserveUnknownFields) {
        this.preserveUnknownFields = preserveUnknownFields;
    }

    @JsonProperty("scope")
    public String getScope() {
        return this.scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("versions")
    public List<CustomResourceDefinitionVersion> getVersions() {
        return this.versions;
    }

    @JsonProperty("versions")
    public void setVersions(List<CustomResourceDefinitionVersion> versions) {
        this.versions = versions;
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
        return "CustomResourceDefinitionSpec(conversion=" + this.getConversion() + ", group=" + this.getGroup() + ", names=" + this.getNames() + ", preserveUnknownFields=" + this.getPreserveUnknownFields() + ", scope=" + this.getScope() + ", versions=" + this.getVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomResourceDefinitionSpec)) {
            return false;
        } else {
            CustomResourceDefinitionSpec other = (CustomResourceDefinitionSpec)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$preserveUnknownFields = this.getPreserveUnknownFields();
                    Object other$preserveUnknownFields = other.getPreserveUnknownFields();
                    if (this$preserveUnknownFields == null) {
                        if (other$preserveUnknownFields == null) {
                            break label95;
                        }
                    } else if (this$preserveUnknownFields.equals(other$preserveUnknownFields)) {
                        break label95;
                    }

                    return false;
                }

                Object this$conversion = this.getConversion();
                Object other$conversion = other.getConversion();
                if (this$conversion == null) {
                    if (other$conversion != null) {
                        return false;
                    }
                } else if (!this$conversion.equals(other$conversion)) {
                    return false;
                }

                Object this$group = this.getGroup();
                Object other$group = other.getGroup();
                if (this$group == null) {
                    if (other$group != null) {
                        return false;
                    }
                } else if (!this$group.equals(other$group)) {
                    return false;
                }

                label74: {
                    Object this$names = this.getNames();
                    Object other$names = other.getNames();
                    if (this$names == null) {
                        if (other$names == null) {
                            break label74;
                        }
                    } else if (this$names.equals(other$names)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$scope = this.getScope();
                    Object other$scope = other.getScope();
                    if (this$scope == null) {
                        if (other$scope == null) {
                            break label67;
                        }
                    } else if (this$scope.equals(other$scope)) {
                        break label67;
                    }

                    return false;
                }

                Object this$versions = this.getVersions();
                Object other$versions = other.getVersions();
                if (this$versions == null) {
                    if (other$versions != null) {
                        return false;
                    }
                } else if (!this$versions.equals(other$versions)) {
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
        return other instanceof CustomResourceDefinitionSpec;
    }

    public int hashCode() {
        int result = 1;
        Object $preserveUnknownFields = this.getPreserveUnknownFields();
        result = result * 59 + ($preserveUnknownFields == null ? 43 : $preserveUnknownFields.hashCode());
        Object $conversion = this.getConversion();
        result = result * 59 + ($conversion == null ? 43 : $conversion.hashCode());
        Object $group = this.getGroup();
        result = result * 59 + ($group == null ? 43 : $group.hashCode());
        Object $names = this.getNames();
        result = result * 59 + ($names == null ? 43 : $names.hashCode());
        Object $scope = this.getScope();
        result = result * 59 + ($scope == null ? 43 : $scope.hashCode());
        Object $versions = this.getVersions();
        result = result * 59 + ($versions == null ? 43 : $versions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * 59 + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }
}
