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
    public void onChangePos(double oldX, double oldY, double oldZ, double newX, double newY, double newZ) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangeYaw(double oldYaw, double newYaw) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangeWidth(int oldWidth, int newWidth) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangeHeight(int oldHeight, int newHeight) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangePixelsPerBlock(double oldPixelsPerBlock, double newPixelsPerBlock) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangeFps(int oldFps, int newFps) {
        throw new NotImplementedException();
    }

    @Override
    public void onChangeBackgroundColor(Color oldBackgroundColor, Color newBackgroundColor) {
        throw new NotImplementedException();
    }
}