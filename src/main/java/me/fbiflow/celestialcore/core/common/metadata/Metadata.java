package me.fbiflow.celestialcore.core.common.metadata;

import me.fbiflow.celestialcore.core.common.metadata.key.MetadataKey;

import java.util.HashMap;
import java.util.Map;

public class Metadata {
    private final Map<String, Map<Class<?>, Object>> metadata = new HashMap<>();

    public <T> void set(MetadataKey<T> key, T value) {
        if (value == null) return;
        metadata.computeIfAbsent(key.name(), k -> new HashMap<>())
                .put(key.type(), value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(MetadataKey<T> key) {
        Map<Class<?>, Object> inner = metadata.get(key.name());
        if (inner == null) return null;
        return (T) inner.get(key.type());
    }

    public <T> T getOrDefault(MetadataKey<T> key, T defaultValue) {
        T value = get(key);
        return value != null ? value : defaultValue;
    }

    public boolean has(MetadataKey<?> key) {
        Map<Class<?>, Object> inner = metadata.get(key.name());
        return inner != null && inner.containsKey(key.type());
    }
}