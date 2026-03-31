package me.fbiflow.celestialcore.graphic.engine2d.service;

import me.fbiflow.celestialcore.graphic.engine2d.screen.Screen;

import java.util.Set;

public interface ScreenService {

    void performDrawTick();

    void registerScreen(Screen screen);

    void unregisterScreen(Screen screen);

    Set<Screen> getScreens();
}