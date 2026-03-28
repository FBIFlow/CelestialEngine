package me.fbiflow.celestialcore.core.space;

import me.fbiflow.celestialcore.core.space.generator.SpaceGenerator;
import me.fbiflow.celestialcore.core.space.generator.constant.GeneratorConstants;
import me.fbiflow.celestialcore.core.space.service.simulation.SpaceSimulation;

public class Space {

    private final SpaceGenerator generator;
    private final SpaceSimulation simulation;

    public Space() {
        this.generator = new SpaceGenerator(1, GeneratorConstants.Population.MEDIUM.population);
        this.simulation = new SpaceSimulation();
    }

}