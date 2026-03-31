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
    private ScreenBuffer buffer;

    public Screen(double x, double y, double z, int yaw, int width, int height, double pixelsPerBlock, int fps, Color backgroundColor) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.yaw = yaw;

        this.width = width;
        this.height = height;

        this.pixelsPerBlock = pixelsPerBlock;
        this.fps = fps;

        this.backgroundColor = backgroundColor;
        this.buffer = new ScreenBuffer(this.width, this.height);
    }

    public abstract void updateFrame();

    public double[] getPos() {
        return new double[]{x, y, z};
    }

    public abstract void setPos(double x, double y, double z);

    public double getX() {
        return x;
    }

    public abstract void setX(double x);

    public double getY() {
        return y;
    }

    public abstract void setY(double y);

    public double getZ() {
        return z;
    }

    public abstract void setZ(double z);

    public int getYaw() {
        return yaw;
    }

    public abstract void setYaw(int yaw);

    public int getWidth() {
        return width;
    }

    public abstract void setWidth(int width);

    public int getHeight() {
        return height;
    }

    public abstract void setHeight(int height);

    public double getPixelsPerBlock() {
        return pixelsPerBlock;
    }

    public abstract void setPixelsPerBlock(double pixelsPerBlock);

    public int getFps() {
        return fps;
    }

    public abstract void setFps(int fps);

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public abstract void setBackgroundColor(Color backgroundColor);

    public ScreenBuffer getBuffer() {
        return buffer;
    }

    public abstract void setBuffer(ScreenBuffer buffer);
}