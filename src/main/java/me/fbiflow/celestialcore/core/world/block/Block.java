package me.fbiflow.celestialcore.core.world.block;

public class Block {

    private final int x;
    private final int y;
    private final int z;

    private BlockType blockType;
    private BlockData blockData;

    public Block(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public BlockType getType() {
        return blockType;
    }

    public void setType(BlockType blockType) {
        this.blockType = blockType;
    }

    public BlockData getData() {
        return blockData;
    }

    public void setData(BlockData blockData) {
        this.blockData = blockData;
    }
}
