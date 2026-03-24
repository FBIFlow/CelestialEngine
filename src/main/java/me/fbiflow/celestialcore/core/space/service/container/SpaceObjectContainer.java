package me.fbiflow.celestialcore.core.space.service.container;

import me.fbiflow.celestialcore.core.space.object.SpaceObject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpaceObjectContainer {

    //k - space object, v - mutable list
    private final Map<SpaceObject, Set<SpaceObject>> spaceObjects;

    public SpaceObjectContainer() {
        //TODO: load from datafile
        this.spaceObjects = new HashMap<>();
    }

    public Set<SpaceObject> getChildObjects(SpaceObject parent) {
        return Collections.unmodifiableSet(spaceObjects.getOrDefault(parent, Collections.emptySet()));
    }

    public void setChildObjects(SpaceObject parent, SpaceObject... childObjects) {
        if (childObjects == null || childObjects.length == 0) {
            spaceObjects.remove(parent);
        } else {
            spaceObjects.put(parent, new HashSet<>(Arrays.asList(childObjects)));
        }
    }

    public void addChild(SpaceObject parent, SpaceObject child) {
        spaceObjects.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
    }

    public void removeChild(SpaceObject parent, SpaceObject childToRemove) {
        var children = spaceObjects.get(parent);
        if (children == null) return;
        children.remove(childToRemove);
        if (children.isEmpty()) spaceObjects.remove(parent);
    }
}