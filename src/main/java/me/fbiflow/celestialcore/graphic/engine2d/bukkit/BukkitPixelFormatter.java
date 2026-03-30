package me.fbiflow.celestialcore.graphic.engine2d.bukkit;

import me.fbiflow.celestialcore.graphic.color.Color;
import org.bukkit.Material;

public class BukkitPixelFormatter {

    public static Material format(Color color) {
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

}
