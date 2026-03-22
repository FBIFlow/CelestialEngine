package me.fbiflow.celestialcore.core.world.block;

import me.fbiflow.celestialcore.core.common.MetaData;

public class BlockData {

    private int lightFromSky;
    private int blockLight;
    private MetaData metaData;

    public BlockData(int lightFromSky, int blockLight, MetaData metaData) {
        this.lightFromSky = lightFromSky;
        this.blockLight = blockLight;
        this.metaData = metaData;
    }

    public int getLightFromSky() {
        return lightFromSky;
    }

    public void setLightFromSky(int lightFromSky) {
        this.lightFromSky = lightFromSky;
    }

    public int getBlockLight() {
        return blockLight;
    }

    public void setBlockLight(int blockLight) {
        this.blockLight = blockLight;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
