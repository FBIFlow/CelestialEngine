package me.fbiflow.celestialcore.graphic.engine2d;

import me.fbiflow.celestialcore.graphic.color.Color;

public class ScreenBuffer {

    private Color[][] buffer;

    public ScreenBuffer(int widthPixels, int heightPixels) {
        this.buffer = new Color[widthPixels][heightPixels];
        for (int x = 0; x < widthPixels; x++) {
            for (int y = 0; y < heightPixels; y++) {
                buffer[x][y] = Color.BLACK;
            }
        }

    }

    public void draw(int x, int y, Color color) {
        this.buffer[x][y] = color;
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, Color color) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                buffer[x][y] = color;
            }
        }
    }

    public Color getPixel(int x, int y) {
        return buffer[x][y];
    }
}