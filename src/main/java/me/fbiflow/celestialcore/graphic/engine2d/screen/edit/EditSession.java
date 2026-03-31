package me.fbiflow.celestialcore.graphic.engine2d.screen.edit;

import me.fbiflow.celestialcore.graphic.engine2d.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.screen.buffer.ScreenBuffer;

public class EditSession {

    private final Color[][] buffer;

    private final Color[][] updates;
    private DirtyRect dirtyRect;

    private final int width;
    private final int height;

    public EditSession(ScreenBuffer buffer) {
        this.buffer = buffer.getArray();

        this.updates = new Color[buffer.getWidth()][buffer.getHeight()];
        this.dirtyRect = new DirtyRect();

        this.width = buffer.getWidth();
        this.height = buffer.getHeight();
    }

    public Color[][] getUpdates() {
        return this.updates;
    }

    public DirtyRect getDirtyRect() {
        return this.dirtyRect;
    }

    public void setPixel(int x, int y, Color color) {
        if (isInBounds(x, y)) {
            if (x < dirtyRect.getMinX()) dirtyRect.setMinX(x);
            if (x > dirtyRect.getMaxX()) dirtyRect.setMaxX(x);
            if (y < dirtyRect.getMinY()) dirtyRect.setMinY(y);
            if (y > dirtyRect.getMaxY()) dirtyRect.setMaxY(y);
            this.updates[x][y] = color;
        }
    }

    public Color getPixel(int x, int y) {
        if (isInBounds(x, y)) {
            Color pixel = updates[x][y];
            if (pixel != null) return pixel;
            return buffer[x][y];
        }
        return Color.BLACK;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public EditSession drawLine(int x1, int y1, int x2, int y2, Color color) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        int x = x1;
        int y = y1;

        while (true) {
            setPixel(x, y, color);

            if (x == x2 && y == y2) break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
        return this;
    }

    public EditSession drawRectangle(int x1, int y1, int x2, int y2, Color color) {
        drawLine(x1, y1, x1, y2, color);
        drawLine(x1, y1, x2, y1, color);
        drawLine(x2, y2, x1, y2, color);
        drawLine(x1, y1, x2, y1, color);
        return this;
    }

    public EditSession drawRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                setPixel(x, y, color);
            }
        }
        return this;
    }
}