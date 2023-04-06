
package com.acme.operators.spark.types;

import com.fasterxml.jackson.annotation.*;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instances",
    "memory",
    "memoryRequest",
    "memoryLimit",
    "cpu",
    "cpuRequest",
    "cpuLimit",
    "labels",
    "command",
    "commandArgs"
})
@RegisterForReflection
public class Worker {

    @JsonProperty("instances")
    private Integer instances = 1;
    @JsonProperty("memory")
    private String memory;
    @JsonProperty("memoryRequest")
    private String memoryRequest;
    @JsonProperty("memoryLimit")
    private String memoryLimit;
    @JsonProperty("cpu")
    private String cpu;
    @JsonProperty("cpuRequest")
    private String cpuRequest;
    @JsonProperty("cpuLimit")
    private String cpuLimit;
    @JsonProperty("labels")
    private Map<String, String> labels;
    @JsonProperty("command")
    private List<String> command = new ArrayList<String>();
    @JsonProperty("commandArgs")
    private List<String> commandArgs = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("instances")
    public Integer getInstances() {
        return instances;
    }

    @JsonProperty("instances")
    public void setInstances(Integer instances) {
        this.instances = instances;
    }

    @JsonProperty("memory")
    public String getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(String memory) {
        this.memory = memory;
    }

    @JsonProperty("memoryRequest")
    public String getMemoryRequest() {
        return memoryRequest;
    }

    @JsonProperty("memoryRequest")
    public void setMemoryRequest(String memoryRequest) {
        this.memoryRequest = memoryRequest;
    }

    @JsonProperty("memoryLimit")
    public String getMemoryLimit() {
        return memoryLimit;
    }

    @JsonProperty("memoryLimit")
    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    @JsonProperty("cpu")
    public String getCpu() {
        return cpu;
    }

    @JsonProperty("cpu")
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @JsonProperty("cpuRequest")
    public String getCpuRequest() {
        return cpuRequest;
    }

    @JsonProperty("cpuRequest")
    public void setCpuRequest(String cpuRequest) {
        this.cpuRequest = cpuRequest;
    }

    @JsonProperty("cpuLimit")
    public String getCpuLimit() {
        return cpuLimit;
    }

    @JsonProperty("cpuLimit")
    public void setCpuLimit(String cpuLimit) {
        this.cpuLimit = cpuLimit;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("command")
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    @JsonProperty("commandArgs")
    public List<String> getCommandArgs() {
        return commandArgs;
    }

    @JsonProperty("commandArgs")
    public void setCommandArgs(List<String> commandArgs) {
        this.commandArgs = commandArgs;
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
        sb.append(Worker.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("instances");
        sb.append('=');
        sb.append(((this.instances == null)?"<null>":this.instances));
        sb.append(',');
        sb.append("memory");
        sb.append('=');
        sb.append(((this.memory == null)?"<null>":this.memory));
        sb.append(',');
        sb.append("memoryRequest");
        sb.append('=');
        sb.append(((this.memoryRequest == null)?"<null>":this.memoryRequest));
        sb.append(',');
        sb.append("memoryLimit");
        sb.append('=');
        sb.append(((this.memoryLimit == null)?"<null>":this.memoryLimit));
        sb.append(',');
        sb.append("cpu");
        sb.append('=');
        sb.append(((this.cpu == null)?"<null>":this.cpu));
        sb.append(',');
        sb.append("cpuRequest");
        sb.append('=');
        sb.append(((this.cpuRequest == null)?"<null>":this.cpuRequest));
        sb.append(',');
        sb.append("cpuLimit");
        sb.append('=');
        sb.append(((this.cpuLimit == null)?"<null>":this.cpuLimit));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("command");
        sb.append('=');
        sb.append(((this.command == null)?"<null>":this.command));
        sb.append(',');
        sb.append("commandArgs");
        sb.append('=');
        sb.append(((this.commandArgs == null)?"<null>":this.commandArgs));
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
        result = ((result* 31)+((this.memory == null)? 0 :this.memory.hashCode()));
        result = ((result* 31)+((this.instances == null)? 0 :this.instances.hashCode()));
        result = ((result* 31)+((this.cpuLimit == null)? 0 :this.cpuLimit.hashCode()));
        result = ((result* 31)+((this.commandArgs == null)? 0 :this.commandArgs.hashCode()));
        result = ((result* 31)+((this.memoryRequest == null)? 0 :this.memoryRequest.hashCode()));
        result = ((result* 31)+((this.cpu == null)? 0 :this.cpu.hashCode()));
        result = ((result* 31)+((this.memoryLimit == null)? 0 :this.memoryLimit.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.command == null)? 0 :this.command.hashCode()));
        result = ((result* 31)+((this.cpuRequest == null)? 0 :this.cpuRequest.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Worker) == false) {
            return false;
        }
        Worker rhs = ((Worker) other);
        return ((((((((((((this.memory == rhs.memory)||((this.memory!= null)&&this.memory.equals(rhs.memory)))&&((this.instances == rhs.instances)||((this.instances!= null)&&this.instances.equals(rhs.instances))))&&((this.cpuLimit == rhs.cpuLimit)||((this.cpuLimit!= null)&&this.cpuLimit.equals(rhs.cpuLimit))))&&((this.commandArgs == rhs.commandArgs)||((this.commandArgs!= null)&&this.commandArgs.equals(rhs.commandArgs))))&&((this.memoryRequest == rhs.memoryRequest)||((this.memoryRequest!= null)&&this.memoryRequest.equals(rhs.memoryRequest))))&&((this.cpu == rhs.cpu)||((this.cpu!= null)&&this.cpu.equals(rhs.cpu))))&&((this.memoryLimit == rhs.memoryLimit)||((this.memoryLimit!= null)&&this.memoryLimit.equals(rhs.memoryLimit))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.command == rhs.command)||((this.command!= null)&&this.command.equals(rhs.command))))&&((this.cpuRequest == rhs.cpuRequest)||((this.cpuRequest!= null)&&this.cpuRequest.equals(rhs.cpuRequest))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))));
    }

}
