//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {
    private String itemName;

    public Get(String itemName) {
        super(CommandType.GET);
        this.itemName = itemName;
    }

    @Override
    public String execute(GameState gameState) {
        Room currentRoom = gameState.getCurrentRoom();
        Player player = gameState.getPlayer();

        // Check if player already has the item
        if (player.hasItem(itemName) || player.hasEquipment(itemName)) {
            return "You already have " + itemName;
        }

        // Check for Items
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                player.addItem(item);
                currentRoom.removeItem(item);
                return "You pick up: " + itemName;
            }
        }

        // Check for Equipment
        for (Equipment equipment : currentRoom.getEquipments()) {
            if (equipment.getName().equalsIgnoreCase(itemName)) {
                player.addEquipment(equipment);
                currentRoom.removeEquipment(equipment);
                return "You pick up: " + itemName;
            }
        }

        // If item or equipment not found
        return "No " + itemName + " to get.";
    }

    public String getItemName() {
        return itemName;
    }
     @Override
    public String toString() {
        return "get " + itemName;
    }
}