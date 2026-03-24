package me.fbiflow.celestialcore.core.space.generator.constant;

public class GeneratorConstants {

    public enum Population {
        LARGE(1.0),
        MEDIUM(0.5),
        SMALL(0.1);

        public final double population;

        Population(double population) {
            this.population = population;
        }
    }

}