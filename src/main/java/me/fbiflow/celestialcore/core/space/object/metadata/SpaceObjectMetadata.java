package me.fbiflow.celestialcore.core.space.object.metadata;

import java.util.HashMap;
import java.util.Map;

public class SpaceObjectMetadata {

    private final Map<String, Map<Class<?>, Object>> metadata = new HashMap<>();

    public <T> void set(String key, T value) {
        if (value == null) return;
        metadata.computeIfAbsent(key, k -> new HashMap<>())
                .put(value.getClass(), value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        Map<Class<?>, Object> inner = metadata.get(key);
        if (inner == null) return null;
        return (T) inner.get(type);
    }
}