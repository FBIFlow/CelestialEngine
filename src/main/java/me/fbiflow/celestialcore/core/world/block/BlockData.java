package me.fbiflow.celestialcore.core.world.block;

import me.fbiflow.celestialcore.core.world.common.Material;
import me.fbiflow.celestialcore.core.common.metadata.Metadata;

public class BlockData extends Metadata {

    private int lightFromSky;
    private int blockLight;
    private Material type;

    public BlockData(int lightFromSky, int blockLight, Material type) {
        this.lightFromSky = lightFromSky;
        this.blockLight = blockLight;
        this.type = type;
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

    public Material getType() {
        return type;
    }

    public void setType(Material type) {
        this.type = type;
    }
}
