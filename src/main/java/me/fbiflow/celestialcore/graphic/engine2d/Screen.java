package me.fbiflow.celestialcore.graphic.engine2d;

import me.fbiflow.celestialcore.graphic.color.Color;

public class Screen {

    private double xPos;
    private double yPos;
    private double zPos;
    private int yaw;

    private int width;
    private int height;

    private double pixelsPerBlock;

    private Color backgroundColor;
    private ScreenBuffer buffer;

    public Screen(double xPos, double yPos, double zPos, int yaw, int width, int height, double pixelsPerBlock, Color backgroundColor) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
        if (yaw % 90 != 0) {
            throw new IllegalArgumentException("Yaw must be a multiple of 90!");
        }
        this.yaw = yaw;

        this.width = width;
        this.height = height;

        this.pixelsPerBlock = pixelsPerBlock;

        this.backgroundColor = backgroundColor;
        this.buffer = new ScreenBuffer(this.width, this.height);
    }

    public void updateFrame() {
        //TODO:
    }

    public ScreenBuffer getBuffer() {
        return buffer;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
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

    public double getPixelsPerBlock() {
        return pixelsPerBlock;
    }

    public void setPixelsPerBlock(double pixelsPerBlock) {
        this.pixelsPerBlock = pixelsPerBlock;
    }
}