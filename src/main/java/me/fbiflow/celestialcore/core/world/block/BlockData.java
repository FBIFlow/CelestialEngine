package me.fbiflow.celestialcore.core.world.block;

public class BlockData {

    private int lightFromSky;
    private int blockLight;

    public BlockData(int lightFromSky, int blockLight) {
        this.lightFromSky = lightFromSky;
        this.blockLight = blockLight;
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
}
