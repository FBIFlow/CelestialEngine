package me.fbiflow.celestialcore.graphic.engine2d.buffer;

import me.fbiflow.celestialcore.graphic.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.edit.ScreenBufferEditSession;

public class ScreenBuffer {

    private final Color[][] buffer;
    private final int width;
    private final int height;

    private ScreenBufferEditSession editSession;

    public ScreenBuffer(int widthPixels, int heightPixels) {
        this.width = widthPixels;
        this.height = heightPixels;
        this.buffer = new Color[widthPixels][heightPixels];

        for (int x = 0; x < widthPixels; x++) {
            for (int y = 0; y < heightPixels; y++) {
                buffer[x][y] = Color.BLACK;
            }
        }
    }

    public ScreenBufferEditSession editSession() {
        this.editSession = new ScreenBufferEditSession(this);
        return editSession;
    }

    public void setPixel(int x, int y, Color color) {
        if (isInBounds(x, y)) {
            this.buffer[x][y] = color;
        }
    }

    public Color getPixel(int x, int y) {
        if (!isInBounds(x, y)) {
            throw new IllegalArgumentException("Pixel out of bounds");
        }
        if (editSession.hasUpdates()) {
            Color pixel = editSession.getPixel(x, y);
            if (pixel != null) {
                return pixel;
            }
        }
        return this.buffer[x][y];
    }

    public void clear(Color color) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setPixel(x, y, color);
            }
        }
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}