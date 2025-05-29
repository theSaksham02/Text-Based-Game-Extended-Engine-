//package org.uob.a2.gameobjects;

/**
 * Represents an item in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * Items can be collected, used, or interacted with by the player.
 * This class inherits common properties from {@code GameObject}.
 * </p>
 */
public class Item extends GameObject {
    
    // Default constructor
    public Item() {
        super();
    }

    // Parameterized constructor
    public Item(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
    }

    /**
     * Returns a string representation of the item by calling the superclass's {@code toString} method.
     *
     * @return a string describing the item
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Checks if this item can combine with another item.
     * 
     * @param item The item to check for combination
     * @return true if the items can combine, false otherwise
     */
    public boolean canCombineWith(Item item) {
        // Logic to determine if this item can combine with the given item
        return true; // Adjust as needed based on game logic
    }

    /**
     * Combines this item with another item and updates the game state accordingly.
     * 
     * @param item The item to combine with
     * @param gameState The current game state
     */
    public void combineWith(Item item, GameState gameState) {
        // Logic for combining items
        // This could involve creating a new item, changing the state of the items, etc.
    }
}