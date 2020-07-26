package github.niewidzialny84.uberstuff.util.config;

import jdk.internal.jline.internal.Nullable;

import java.util.LinkedHashMap;

public class ConfigMap<K,T> extends LinkedHashMap<K,T> {
    ConfigMap() {
        super();
    }

    public Boolean getBoolean(String key,Boolean def) {
        return (this.get(key) != null ? (Boolean)this.get(key) : def);
    }

    @Nullable
    public Boolean getBoolean(String key) {
        return (this.get(key) != null ? (Boolean)this.get(key) : null);
    }

    public Integer getInt(String key,Integer def) {
        return (this.get(key) != null ? (Integer)this.get(key) : def);
    }

    @Nullable
    public Integer getInt(String key) {
        return (this.get(key) != null ? (Integer)this.get(key) : null);
    }

    public Double getDouble(String key,Double def) {
        return (this.get(key) != null ? (Double)this.get(key) : def);
    }

    @Nullable
    public Double getDouble(String key) {
        return (this.get(key) != null ? (Double)this.get(key) : null);
    }

    public String getString(String key,String def) {
        return (this.get(key) != null ? (String)this.get(key) : def);
    }

    @Nullable
    public String getString(String key) {
        return (this.get(key) != null ? (String)this.get(key) : null);
    }
}
