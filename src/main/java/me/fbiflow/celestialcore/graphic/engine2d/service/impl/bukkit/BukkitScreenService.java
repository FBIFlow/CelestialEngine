package me.fbiflow.celestialcore.graphic.engine2d.service.impl.bukkit;

import me.fbiflow.celestialcore.graphic.engine2d.screen.Screen;
import me.fbiflow.celestialcore.graphic.engine2d.service.ScreenService;

import java.util.HashSet;
import java.util.Set;

public class BukkitScreenService implements ScreenService {

    private final Set<Screen> screens;

    public BukkitScreenService() {
        screens = new HashSet<>();
    }

    @Override
    public void performDrawTick() {

    }

    @Override
    public void registerScreen(Screen screen) {
        screens.add(screen);
    }

    @Override
    public void unregisterScreen(Screen screen) {
        screens.remove(screen);
    }

    @Override
    public Set<Screen> getScreens() {
        return screens;
    }

}