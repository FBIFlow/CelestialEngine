package me.fbiflow.celestialcore.core.space.object;

import me.fbiflow.celestialcore.core.common.metadata.Metadata;

import java.util.UUID;

public class SpaceObject {

    private String name;
    private String signature;
    private UUID uniqueId;
    private int mass;
    private int speed;
    private int orbitalRadius;

    private Metadata metadata;

    public SpaceObject() {

    }

}