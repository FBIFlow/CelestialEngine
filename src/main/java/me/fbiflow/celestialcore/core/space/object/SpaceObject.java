package me.fbiflow.celestialcore.core.space.object;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpaceObject {

    private String name;
    private UUID uniqueId;
    private double weight;
    private double orbitalRadius;
    private List<SpaceObject> satellites;

    public SpaceObject(String name, UUID uniqueId, double weight, double orbitalRadius) {
        this.name = name;
        this.uniqueId = uniqueId;
        this.weight = weight;
        this.orbitalRadius = orbitalRadius;
    }

    public SpaceObject(String name, UUID uniqueId, double weight, double orbitalRadius, List<SpaceObject> satellites) {
        this(name, uniqueId, weight, orbitalRadius);
        this.satellites = new ArrayList<>(satellites);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getOrbitalRadius() {
        return orbitalRadius;
    }

    public void setOrbitalRadius(double orbitalRadius) {
        this.orbitalRadius = orbitalRadius;
    }

    public List<SpaceObject> getSatellites() {
        return new ArrayList<>(satellites);
    }

    public void setSatellites(List<SpaceObject> satellites) {
        this.satellites = new ArrayList<>(satellites);
    }
}