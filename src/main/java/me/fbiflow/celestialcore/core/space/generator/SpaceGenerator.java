package me.fbiflow.celestialcore.core.space.generator;

import me.fbiflow.celestialcore.core.space.generator.config.SpaceGeneratorConfig;
import me.fbiflow.celestialcore.core.space.generator.population.PopulationGenerator;
import me.fbiflow.celestialcore.core.space.generator.spaceobject.SpaceObjectGenerator;

public class SpaceGenerator {

    private final int seed;

    private final SpaceGeneratorConfig config;
    private final PopulationGenerator populationGenerator;
    private final SpaceObjectGenerator spaceObjectGenerator;

    public SpaceGenerator() {
        this.config = new SpaceGeneratorConfig();
        this.seed = config.getSeed();
        this.populationGenerator = new PopulationGenerator(seed, config.getPopulation());
        this.spaceObjectGenerator = new SpaceObjectGenerator(seed);
    }



}