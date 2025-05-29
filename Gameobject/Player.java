//package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name; 
    private List<Item> inventory; 
    private List<Equipment> equipment;

    public Player() {
        this.name = "Player";
        this.inventory = new ArrayList<>();
        this.equipment = new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.equipment = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    public Equipment getEquipment(String name) {
        for (Equipment e : equipment) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null; // Return null if not found
    }

    public boolean hasEquipment(String name) {
        return equipment.stream().anyMatch(e -> e.getName().equalsIgnoreCase(name));
    }

    public boolean removeItem(Item item) {
        return inventory.remove(item);
    }

    public boolean hasItem(String itemName) {
        return inventory.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipment) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}