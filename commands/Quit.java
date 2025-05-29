//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.*;

public class Quit extends Command {

    public Quit() {
        super(CommandType.QUIT);
    }

    @Override
    public String execute(GameState gameState) {
        Player player = gameState.getPlayer();
        
        // Start the game over message
        StringBuilder result = new StringBuilder("Game over: ");
        
        // Check if inventory is empty
        if (player.getInventory().isEmpty() && player.getEquipment().isEmpty()) {
            result.append("No items in inventory.");
        } else {
            // Add inventory items to the message
            result.append("Inventory:\n");
            
            // Add items
            for (Item item : player.getInventory()) {
                result.append("- ").append(item.getName().toLowerCase()).append("\n");
            }
            
            // Add equipment
            for (Equipment equipment : player.getEquipment()) {
                result.append("- ").append(equipment.getName().toLowerCase()).append("\n");
            }
        }
        
        return result.toString();
    }
}