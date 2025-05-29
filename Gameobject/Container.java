//package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a container in the game, which is a type of feature that may contain items
 * or serve as an interactable object within a room.
 * 
 * <p>
 * Containers can have a name, description, and visibility state, which determines if they
 * are initially hidden or visible to the player.
 * </p>
 */
public class Container extends Feature {
    private ArrayList<Item> items; // List to hold items contained in the container

    // Default constructor
    public Container() {
        super();
        this.items = new ArrayList<>(); // Initialize the items list
    }

    // Parameterized constructor
    public Container(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
        this.items = new ArrayList<>(); // Initialize the items list
    }

    // Method to add an item to the container
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to remove an item from the container
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    // Method to get the items in the container
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Returns a string representation of the container.
     *
     * @return a string containing the container's id, name, description, hidden status, and contained items
     */
    @Override
    public String toString() {
        return "Container {" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", hidden=" + isHidden() +
                ", items=" + items +
                '}';
    }
}