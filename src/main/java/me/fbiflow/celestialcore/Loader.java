package me.fbiflow.celestialcore;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.fbiflow.celestialcore.graphic.color.Color;
import me.fbiflow.celestialcore.graphic.engine2d.Screen;
import me.fbiflow.celestialcore.graphic.engine2d.impl.bukkit.BukkitScreen;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
                80, 60, 15, Color.GREEN
        );
        new BukkitRunnable() {
            @Override
            public void run() {
                screen.placeDisplay();
                var editSession = screen.editSession();
                editSession.drawRectangleOutline(0, 0, screen.getWidth() - 1, screen.getHeight() - 1, Color.BLACK);
                editSession.drawCircle(20, 15, 5, Color.RED);
                editSession.drawLine(15, 15, 25, 15, Color.RED);
                editSession.drawLine(20, 10, 20, 20, Color.RED);
                editSession.drawCircle(20, 15, 2, Color.BLACK);
                editSession.applyUpdates();
                screen.updateFrame();
            }
        }.runTask(this);
    }


    @Override
    public void onDisable() {

    }
}