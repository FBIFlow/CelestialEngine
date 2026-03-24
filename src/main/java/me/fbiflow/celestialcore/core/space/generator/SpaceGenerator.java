package me.fbiflow.celestialcore.core.space.generator;

import me.fbiflow.celestialcore.core.space.generator.population.PopulationGenerator;
import me.fbiflow.celestialcore.core.space.generator.spaceobject.SpaceObjectGenerator;

public class SpaceGenerator {

    private final int seed;

    private final PopulationGenerator populationGenerator;
    private final SpaceObjectGenerator spaceObjectGenerator;

    public SpaceGenerator(int seed, double population) {
        this.seed = seed;
        this.populationGenerator = new PopulationGenerator(seed, population);
        this.spaceObjectGenerator = new SpaceObjectGenerator();
    }



}