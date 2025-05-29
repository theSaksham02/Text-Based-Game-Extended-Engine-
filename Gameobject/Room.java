//package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Room extends GameObject {
    private List<Item> items; 
    private List<Equipment> equipment; 
    private List<Feature> features; 
    private List<Exit> exits; 
    private boolean visited;

    public Room(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
        this.items = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.features = new ArrayList<>();
        this.exits = new ArrayList<>();
        this.visited = false;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Item getItem(String identifier) {
        // First, try to find by ID
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(identifier)) {
                return item;
            }
        }
        
        // If not found by ID, try by name
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(identifier)) {
                return item;
            }
        }
        
        // Return null if no item found
        return null;
    }

    public boolean hasItem(String name) {
        return getItemByName(name) != null;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Feature getFeature(String identifier) {
    // First, try to find by ID
    for (Feature feature : features) {
        if (feature.getId().equalsIgnoreCase(identifier)) {
            return feature;
        }
    }
    
    // If not found by ID, try by name
    for (Feature feature : features) {
        if (feature.getName().equalsIgnoreCase(identifier)) {
            return feature;
        }
    }
    
    // Return null if no feature found
    return null;
}

    public List<Exit> getExits() {
        return exits;
    }

    public String getExitDestination(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit.getDestinationRoomId();
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeEquipment(Equipment equipment) {
        this.equipment.remove(equipment);
    }

    public List<Equipment> getEquipments() {
        return equipment;
    }

    public Equipment getEquipment(String name) {
        for (Equipment e : equipment) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public boolean hasEquipment(String name) {
        return equipment.stream().anyMatch(e -> e.getName().equalsIgnoreCase(name));
    }

    public Exit getExit(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[" + getId() + "] Room: " + getName() + "\nDescription: " + getDescription() + "\nIn the room there is: ");
        for (Item i : this.items) {
            out.append(i).append("\n");
        }
        for (Equipment e : this.equipment) {
            out.append(e).append("\n");
        }
        for (Feature f : this.features) {
            out.append(f).append("\n");
        }
        for (Exit e : this.exits) {
            out.append(e).append("\n");
        }
        return out.toString();
    }
}