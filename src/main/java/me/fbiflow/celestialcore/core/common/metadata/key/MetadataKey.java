package me.fbiflow.celestialcore.core.common.metadata.key;

public record MetadataKey<T>(String name, Class<T> type) {

    @Override
    public String toString() {
        return name;
    }
}