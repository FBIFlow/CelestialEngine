package me.fbiflow.celestialcore;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.fbiflow.celestialcore.graphic.engine2d.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.screen.impl.bukkit.BukkitScreen;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Loader extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCommand(AsyncChatEvent event) {
        if (!event.message().toString().contains("test")) {
            return;
        }
        var world = event.getPlayer().getWorld();
        var screen = new BukkitScreen(
                world, 0, -56, 0, 0,
                80, 60, 15, 50, Color.GREEN
        );
        new BukkitRunnable() {
            @Override
            public void run() {
                screen.placeDisplay();

                screen.updateFrame();
            }
        }.runTask(this);
    }


    @Override
    public void onDisable() {

    }
}