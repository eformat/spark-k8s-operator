
package com.acme.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "principal",
    "keytab"
})
@RegisterForReflection
public class Kerberos {

    /**
     * Indicates whether the history server should use kerberos to login. This is required if the history server is accessing HDFS files on a secure Hadoop cluster. If this is true, it uses the configs spark.history.kerberos.principal and spark.history.kerberos.keytab.
     * 
     */
    @JsonProperty("enabled")
    @JsonPropertyDescription("Indicates whether the history server should use kerberos to login. This is required if the history server is accessing HDFS files on a secure Hadoop cluster. If this is true, it uses the configs spark.history.kerberos.principal and spark.history.kerberos.keytab.")
    private Boolean enabled = false;
    /**
     * Kerberos principal name for the History Server.
     * 
     */
    @JsonProperty("principal")
    @JsonPropertyDescription("Kerberos principal name for the History Server.")
    private String principal;
    /**
     * Location of the kerberos keytab file for the History Server.
     * 
     */
    @JsonProperty("keytab")
    @JsonPropertyDescription("Location of the kerberos keytab file for the History Server.")
    private String keytab;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Indicates whether the history server should use kerberos to login. This is required if the history server is accessing HDFS files on a secure Hadoop cluster. If this is true, it uses the configs spark.history.kerberos.principal and spark.history.kerberos.keytab.
     * 
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Indicates whether the history server should use kerberos to login. This is required if the history server is accessing HDFS files on a secure Hadoop cluster. If this is true, it uses the configs spark.history.kerberos.principal and spark.history.kerberos.keytab.
     * 
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Kerberos principal name for the History Server.
     * 
     */
    @JsonProperty("principal")
    public String getPrincipal() {
        return principal;
    }

    /**
     * Kerberos principal name for the History Server.
     * 
     */
    @JsonProperty("principal")
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * Location of the kerberos keytab file for the History Server.
     * 
     */
    @JsonProperty("keytab")
    public String getKeytab() {
        return keytab;
    }

    /**
     * Location of the kerberos keytab file for the History Server.
     * 
     */
    @JsonProperty("keytab")
    public void setKeytab(String keytab) {
        this.keytab = keytab;
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
        sb.append(Kerberos.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("enabled");
        sb.append('=');
        sb.append(((this.enabled == null)?"<null>":this.enabled));
        sb.append(',');
        sb.append("principal");
        sb.append('=');
        sb.append(((this.principal == null)?"<null>":this.principal));
        sb.append(',');
        sb.append("keytab");
        sb.append('=');
        sb.append(((this.keytab == null)?"<null>":this.keytab));
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
        result = ((result* 31)+((this.principal == null)? 0 :this.principal.hashCode()));
        result = ((result* 31)+((this.keytab == null)? 0 :this.keytab.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.enabled == null)? 0 :this.enabled.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Kerberos) == false) {
            return false;
        }
        Kerberos rhs = ((Kerberos) other);
        return (((((this.principal == rhs.principal)||((this.principal!= null)&&this.principal.equals(rhs.principal)))&&((this.keytab == rhs.keytab)||((this.keytab!= null)&&this.keytab.equals(rhs.keytab))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.enabled == rhs.enabled)||((this.enabled!= null)&&this.enabled.equals(rhs.enabled))));
    }

}
