package me.fbiflow.celestialcore.graphic.engine2d.bukkit;

import me.fbiflow.celestialcore.Loader;
import me.fbiflow.celestialcore.graphic.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.Screen;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class BukkitScreen extends Screen {

    private World world;
    private ItemDisplay[][] displayItems;

    public BukkitScreen(World world, double xPos, double yPos, double zPos, int yaw, int width, int height, double pixelsPerBlock, Color backgroundColor) {
        super(xPos, yPos, zPos, yaw, width, height, pixelsPerBlock, backgroundColor);
        this.world = world;
        this.displayItems = new ItemDisplay[super.getWidth()][super.getHeight()];
    }

    public void placeDisplay() {
        double x = getXPos();
        double y = getYPos();
        double z = getZPos();
        Location location = new Location(world, x, y, z);

        double offset = 1 / getPixelsPerBlock();
        double pixelScale = offset;

        for (int width = 0; width < getWidth(); width++) {
            for (int height = 0; height < getHeight(); height++) {
                var loc = location.clone().add(offset * width, offset * height, 0);
                var display = (ItemDisplay) world.spawnEntity(loc, EntityType.ITEM_DISPLAY);
                var transform = display.getTransformation();
                transform.getScale().set(pixelScale);
                display.setTransformation(transform);
                displayItems[width][height] = display;
                display.setItemStack(ItemStack.of(BukkitPixelFormatter.format(getBackgroundColor())));
            }
        }
    }

    @Override
    public void updateFrame() {
        super.updateFrame();
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int width = 0; width < getWidth(); width++) {
                    for (int height = 0; height < getHeight(); height++) {
                        displayItems[width][height].setItemStack(ItemStack.of(BukkitPixelFormatter.format(getBuffer().getPixel(width, height))));
                    }
                }
            }
        }.runTask(Loader.getPlugin(Loader.class));
    }
}
