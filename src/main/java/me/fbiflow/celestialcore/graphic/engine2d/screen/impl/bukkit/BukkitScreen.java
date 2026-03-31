package me.fbiflow.celestialcore.graphic.engine2d.screen.impl.bukkit;

import me.fbiflow.celestialcore.Loader;
import me.fbiflow.celestialcore.graphic.engine2d.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.screen.Screen;
import me.fbiflow.celestialcore.graphic.engine2d.screen.buffer.ScreenBuffer;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class BukkitScreen extends Screen {

    private World world;
    private ItemDisplay[][] displayItems;

    public BukkitScreen(World world, double xPos, double yPos, double zPos, int yaw, int width, int height, double pixelsPerBlock, int fps, Color backgroundColor) {
        super(xPos, yPos, zPos, yaw, width, height, pixelsPerBlock, fps, backgroundColor);
        this.world = world;
        this.displayItems = new ItemDisplay[super.getWidth()][super.getHeight()];
    }

    public void placeDisplay() {
        var pos = getPos();
        Location location = new Location(world, pos[0], pos[1], pos[2]);

        double offset = 1 / getPixelsPerBlock();
        double pixelScale = offset;

        for (int width = 0; width < getWidth(); width++) {
            for (int height = 0; height < getHeight(); height++) {
                var loc = location.clone().add(offset * width, offset * height, 0);
                var display = (ItemDisplay) world.spawnEntity(loc, EntityType.ITEM_DISPLAY);
                display.setBrightness(new Display.Brightness(15, 15));
                var transform = display.getTransformation();
                transform.getScale().set(pixelScale);
                display.setTransformation(transform);
                displayItems[width][height] = display;
                display.setItemStack(BukkitPixelFormatter.formatToItemStack(getBackgroundColor()));
            }
        }
    }

    @Override
    public void updateFrame() {
        new BukkitRunnable() {
            //Если есть editSessionUpdates -> рисовать по dirtyFrame
            //Иначе - полная отрисовка
            @Override
            public void run() {
                for (int width = 0; width < getWidth(); width++) {
                    for (int height = 0; height < getHeight(); height++) {
                        var color = getBuffer().getPixel(width, height);
                        var itemStack = BukkitPixelFormatter.formatToItemStack(color);
                        displayItems[width][height].setItemStack(itemStack);
                    }
                }
            }
        }.runTask(Loader.getPlugin(Loader.class));
    }

    @Override
    public void setPos(double x, double y, double z) {
        throw new NotImplementedException();
    }

    @Override
    public void setHeight(int height) {
        throw new NotImplementedException();
    }

    @Override
    public void setWidth(int width) {
        throw new NotImplementedException();
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        throw new NotImplementedException();
    }

    @Override
    public void setBuffer(ScreenBuffer buffer) {
        throw new NotImplementedException();
    }

    @Override
    public void setX(double x) {
        throw new NotImplementedException();
    }

    @Override
    public void setY(double y) {
        throw new NotImplementedException();
    }

    @Override
    public void setZ(double z) {
        throw new NotImplementedException();
    }

    @Override
    public void setYaw(int yaw) {
        throw new NotImplementedException();
    }

    @Override
    public void setPixelsPerBlock(double pixelsPerBlock) {
        throw new NotImplementedException();
    }

    @Override
    public void setFps(int fps) {
        throw new NotImplementedException();
    }
}