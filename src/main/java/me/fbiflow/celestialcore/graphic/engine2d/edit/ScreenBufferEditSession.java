package me.fbiflow.celestialcore.graphic.engine2d.edit;

import me.fbiflow.celestialcore.graphic.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.buffer.ScreenBuffer;

public class ScreenBufferEditSession {

    private final ScreenBuffer buffer;

    private final Color[][] updates;
    private boolean hasUpdates = false;

    public ScreenBufferEditSession(ScreenBuffer buffer) {
        this.buffer = buffer;
        this.updates = new Color[buffer.getWidth()][buffer.getHeight()];
    }

    public void applyUpdates() {
        this.hasUpdates = true;
    }

    public void forceUpdate() {
        for(int x = 0; x < buffer.getWidth(); x++) {
            for(int y = 0; y < buffer.getHeight(); y++) {
                buffer.setPixel(x, y, updates[x][y] != null ? updates[x][y] : buffer.getPixel(x,y));
            }
        }
    }

    public void setPixel(int x, int y, Color color) {
        if (isInBounds(x, y)) {
            this.updates[x][y] = color;
        }
    }

    public Color getPixel(int x, int y) {
        return isInBounds(x, y) ? updates[x][y] : Color.BLACK;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < buffer.getWidth() && y >= 0 && y < buffer.getHeight();
    }

    public boolean hasUpdates() {
        return this.hasUpdates;
    }

    public ScreenBufferEditSession drawRectangle(int x1, int y1, int x2, int y2, Color color) {
        int startX = Math.max(0, Math.min(x1, x2));
        int endX = Math.min(buffer.getWidth(), Math.max(x1, x2));
        int startY = Math.max(0, Math.min(y1, y2));
        int endY = Math.min(buffer.getHeight(), Math.max(y1, y2));

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                setPixel(x, y, color);
            }
        }
        return this;
    }

    public ScreenBufferEditSession drawLine(int x1, int y1, int x2, int y2, Color color) {
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

    public ScreenBufferEditSession drawCircle(int centerX, int centerY, int radius, Color color) {
        int x = radius;
        int y = 0;
        int err = 0;

        while (x >= y) {
            setPixel(centerX + x, centerY + y, color);
            setPixel(centerX + y, centerY + x, color);
            setPixel(centerX - y, centerY + x, color);
            setPixel(centerX - x, centerY + y, color);
            setPixel(centerX - x, centerY - y, color);
            setPixel(centerX - y, centerY - x, color);
            setPixel(centerX + y, centerY - x, color);
            setPixel(centerX + x, centerY - y, color);

            y++;
            err += 2 * y + 1;
            if (2 * err >= 2 * x - 1) {
                x--;
                err += -2 * x + 1;
            }
        }
        return this;
    }

    public ScreenBufferEditSession drawFilledCircle(int centerX, int centerY, int radius, Color color) {
        int x = radius;
        int y = 0;
        int err = 0;

        while (x >= y) {
            for (int i = -x; i <= x; i++) {
                setPixel(centerX + i, centerY + y, color);
                setPixel(centerX + i, centerY - y, color);
            }
            for (int i = -y; i <= y; i++) {
                setPixel(centerX + i, centerY + x, color);
                setPixel(centerX + i, centerY - x, color);
            }

            y++;
            err += 2 * y + 1;
            if (2 * err >= 2 * x - 1) {
                x--;
                err += -2 * x + 1;
            }
        }
        return this;
    }

    public ScreenBufferEditSession drawRectangleOutline(int x1, int y1, int x2, int y2, Color color) {
        int startX = Math.min(x1, x2);
        int endX = Math.max(x1, x2);
        int startY = Math.min(y1, y2);
        int endY = Math.max(y1, y2);

        for (int x = startX; x <= endX; x++) {
            setPixel(x, startY, color);
            setPixel(x, endY, color);
        }
        for (int y = startY + 1; y < endY; y++) {
            setPixel(startX, y, color);
            setPixel(endX, y, color);
        }
        return this;
    }

    public ScreenBufferEditSession drawEllipse(int centerX, int centerY, int radiusX, int radiusY, Color color) {
        int x = 0;
        int y = radiusY;
        int rxSq = radiusX * radiusX;
        int rySq = radiusY * radiusY;
        int twoRxSq = 2 * rxSq;
        int twoRySq = 2 * rySq;
        int p;

        int xChange = rySq * (1 - 2 * radiusX);
        int yChange = rxSq;
        p = (int)(rySq - (rxSq * radiusY) + (0.25 * rxSq));

        while (xChange < yChange) {
            setPixel(centerX + x, centerY + y, color);
            setPixel(centerX - x, centerY + y, color);
            setPixel(centerX + x, centerY - y, color);
            setPixel(centerX - x, centerY - y, color);

            x++;
            xChange += twoRySq;
            if (p < 0) {
                p += rySq + xChange;
            } else {
                y--;
                yChange -= twoRxSq;
                p += rySq + xChange - yChange;
            }
        }

        p = (int)(rySq * (x + 0.5) * (x + 0.5) + rxSq * (y - 1) * (y - 1) - rxSq * rySq);
        while (y >= 0) {
            setPixel(centerX + x, centerY + y, color);
            setPixel(centerX - x, centerY + y, color);
            setPixel(centerX + x, centerY - y, color);
            setPixel(centerX - x, centerY - y, color);

            y--;
            yChange -= twoRxSq;
            if (p > 0) {
                p += rxSq - yChange;
            } else {
                x++;
                xChange += twoRySq;
                p += rxSq - yChange + xChange;
            }
        }
        return this;
    }
}