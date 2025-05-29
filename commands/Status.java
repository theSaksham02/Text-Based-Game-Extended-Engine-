//package org.uob.a2.commands;

/*import org.uob.a2.gameobjects.GameState;
import org.uob.a2.gameobjects.Player;
import org.uob.a2.gameobjects.Item;
import org.uob.a2.gameobjects.Equipment; */

public class Status extends Command {
    private String topic;

    // No-arg constructor
    public Status() {
        super(CommandType.STATUS);
    }

    // Constructor with topic
    public Status(String topic) {
        super(CommandType.STATUS);
        this.topic = topic;
    }

    @Override
    public String execute(GameState gameState) {
        // Null check for gameState
        if (gameState == null) {
            return "";
        }

        Player player = gameState.getPlayer();
        
        // Handle inventory status
        if (topic != null && topic.equalsIgnoreCase("inventory")) {
            StringBuilder sb = new StringBuilder();
            for (Item item : player.getInventory()) {
                sb.append(item.getName()).append("\n");
            }
            for (Equipment eq : player.getEquipment()) {
                sb.append(eq.getName()).append("\n");
            }
            return sb.toString().trim();
        }

        // Handle player status
        if (topic != null && topic.equalsIgnoreCase("player")) {
            return "Player";
        }

        // Handle specific item/equipment status
        if (topic != null) {
            // Check items
            for (Item item : player.getInventory()) {
                if (item.getName().equalsIgnoreCase(topic)) {
                    return item.getDescription();
                }
            }

            // Check equipment
            for (Equipment eq : player.getEquipment()) {
                if (eq.getName().equalsIgnoreCase(topic)) {
                    return eq.getDescription();
                }
            }
        }

        // Default case
        return "";
    }

    // Getter for topic
    public String getTopic() {
        return topic;
    }

    // Optional method for additional details
    private void showItemDetails(GameState gameState) {
        if (gameState == null || topic == null) return;

        Player player = gameState.getPlayer();
        Item specificItem = null;
        
        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(topic)) {
                specificItem = item;
                break;
            }
        }

        if (specificItem == null) {
            System.out.println("Item '" + topic + "' not found in your inventory.");
            return;
        }
        
        System.out.println("\nItem Details:");
        System.out.println("Name: " + specificItem.getName());
        System.out.println("Description: " + specificItem.getDescription());
    }
}