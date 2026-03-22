package me.fbiflow.celestialcore.graphic.engine2d;

public class Screen {

    private double xPos;
    private double yPos;
    private double zPos;
    private int yaw;

    private double widthBlocks;
    private double heightBlocks;
    private double pixelSize;

    public Screen(double xPos, double yPos, double zPos, int yaw, double widthBlocks, double heightBlocks, double pixelSize) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
        this.widthBlocks = widthBlocks;
        this.heightBlocks = heightBlocks;
        if (yaw % 90 != 0) {
            throw new IllegalArgumentException("Yaw must be a multiple of 90!");
        }
        this.yaw = yaw;
        this.pixelSize = pixelSize;
    }

    public double getXPos() {
        return xPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public double getZPos() {
        return zPos;
    }

    public void setZPos(double zPos) {
        this.zPos = zPos;
    }

    public int getYaw() {
        return yaw;
    }

    public void setYaw(int yaw) {
        if (yaw % 90 != 0) {
            throw new IllegalArgumentException("Yaw must be a multiple of 90!");
        }
        this.yaw = yaw;
    }

    public double getWidthBlocks() {
        return widthBlocks;
    }

    public void setWidthBlocks(double widthBlocks) {
        this.widthBlocks = widthBlocks;
    }

    public double getHeightBlocks() {
        return heightBlocks;
    }

    public void setHeightBlocks(double heightBlocks) {
        this.heightBlocks = heightBlocks;
    }

    public double getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(double pixelSize) {
        this.pixelSize = pixelSize;
    }
}