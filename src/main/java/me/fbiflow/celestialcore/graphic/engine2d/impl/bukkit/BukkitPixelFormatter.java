package me.fbiflow.celestialcore.graphic.engine2d.impl.bukkit;

import me.fbiflow.celestialcore.graphic.color.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class BukkitPixelFormatter {

    private static final Map<Color, ItemStack> itemStackMap = Map.of(
            Color.BLACK, ItemStack.of(Material.BLACK_CONCRETE),
            Color.WHITE, ItemStack.of(Material.WHITE_CONCRETE),
            Color.RED, ItemStack.of(Material.RED_CONCRETE),
            Color.YELLOW, ItemStack.of(Material.RED_CONCRETE),
            Color.BLUE, ItemStack.of(Material.BLUE_CONCRETE),
            Color.ORANGE, ItemStack.of(Material.ORANGE_CONCRETE),
            Color.GREEN, ItemStack.of(Material.GREEN_CONCRETE),
            Color.PURPLE, ItemStack.of(Material.PURPLE_CONCRETE)
    );

    public static Material formatToMaterial(Color color) {
        return switch (color) {
            case BLACK -> Material.BLACK_CONCRETE;
            case WHITE -> Material.WHITE_CONCRETE;
            case RED -> Material.RED_CONCRETE;
            case YELLOW -> Material.YELLOW_CONCRETE;
            case BLUE -> Material.BLUE_CONCRETE;
            case ORANGE -> Material.ORANGE_CONCRETE;
            case GREEN -> Material.GREEN_CONCRETE;
            case PURPLE -> Material.PURPLE_CONCRETE;
        };
    }

    public static ItemStack formatToItemStack(Color color) {
        return itemStackMap.get(color);
    }

}
