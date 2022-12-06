package com.acme.operators;
import java.util.Objects;

public abstract class EntityInfo {
    protected String name;
    protected String namespace;

    public EntityInfo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            EntityInfo that = (EntityInfo)o;
            return Objects.equals(this.name, that.name) && Objects.equals(this.namespace, that.namespace);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.namespace});
    }
}
