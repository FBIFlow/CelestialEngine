package me.fbiflow.celestialcore.core.common;

import java.util.HashMap;
import java.util.Map;

public class MetaData {

    private Map<Object, Object> dataContainer;

    {
        this.dataContainer = new HashMap<>();
    }

    public Map<Object, Object> getDataContainer() {
        return new HashMap<>(dataContainer);
    }

    public void setDataContainer(Map<Object, Object> dataContainer) {
        this.dataContainer = dataContainer;
    }

}