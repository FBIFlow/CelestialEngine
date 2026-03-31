package me.fbiflow.celestialcore.graphic.engine2d.screen;

import me.fbiflow.celestialcore.graphic.engine2d.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.screen.buffer.ScreenBuffer;

public abstract class Screen {

    private double x;
    private double y;
    private double z;
    private int yaw;

    private int width;
    private int height;

    private double pixelsPerBlock;
    private int fps;

    private Color backgroundColor;
    private final ScreenBuffer buffer;

    public Screen(double x, double y, double z, int yaw, int width, int height, double pixelsPerBlock, int fps, Color backgroundColor) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.yaw = yaw;

        this.width = width;
        this.height = height;

        this.pixelsPerBlock = pixelsPerBlock;
        this.setFps(fps);

        this.backgroundColor = backgroundColor;
        this.buffer = new ScreenBuffer(this.width, this.height);
    }

    public abstract void updateFrame();

    public double[] getPos() {
        return new double[]{x, y, z};
    }

    public final void setPos(double x, double y, double z) {
        double oldX = this.x;
        double oldY = this.y;
        double oldZ = this.z;

        this.x = x;
        this.y = y;
        this.z = z;

        onChangePos(oldX, oldY, oldZ, x, y, z);
    }

    public abstract void onChangePos(double oldX, double oldY, double oldZ, double newX, double newY, double newZ);

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getZ() {
        return z;
    }

    public final int getYaw() {
        return yaw;
    }

    public final void setYaw(int yaw) {
        int oldYaw = this.yaw;
        if (yaw < 0 || yaw > 360) {
            throw new IllegalArgumentException("Yaw must be between 0 and 360.");
        }
        this.yaw = yaw;
        onChangeYaw(oldYaw, yaw);
    }

    public abstract void onChangeYaw(double oldYaw, double newYaw);

    public final int getWidth() {
        return width;
    }

    public final void setWidth(int width) {
        int oldWidth = this.width;
        this.width = width;
        onChangeWidth(oldWidth, width);
    }

    public abstract void onChangeWidth(int oldWidth, int newWidth);


    public final int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height;
        onChangeHeight(oldHeight, height);
    }

    public abstract void onChangeHeight(int oldHeight, int newHeight);

    public final double getPixelsPerBlock() {
        return pixelsPerBlock;
    }

    public final void setPixelsPerBlock(double pixelsPerBlock) {
        double oldPixelsPerBlock = this.pixelsPerBlock;
        this.pixelsPerBlock = pixelsPerBlock;
        onChangePixelsPerBlock(oldPixelsPerBlock, pixelsPerBlock);
    }

    public abstract void onChangePixelsPerBlock(double oldPixelsPerBlock, double newPixelsPerBlock);

    public final int getFps() {
        return fps;
    }

    public final void setFps(int fps) {
        int oldFps = this.fps;
        if (fps < 1 || fps > 60) {
            throw new IllegalArgumentException("FPS must be 1-60.");
        }
        this.fps = fps;
        onChangeFps(oldFps, fps);
    }

    public abstract void onChangeFps(int oldFps, int newFps);

    public final Color getBackgroundColor() {
        return backgroundColor;
    }

    public final void setBackgroundColor(Color backgroundColor) {
        Color oldBackgroundColor = this.backgroundColor;
        this.backgroundColor = backgroundColor;
        onChangeBackgroundColor(oldBackgroundColor, backgroundColor);
    }

    public abstract void onChangeBackgroundColor(Color oldBackgroundColor, Color newBackgroundColor);

    public final ScreenBuffer getBuffer() {
        return buffer;
    }

}