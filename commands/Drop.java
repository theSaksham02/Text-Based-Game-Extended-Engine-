//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.*;

public class Drop extends Command {
    private String itemName;

    public Drop(String itemName) {
        super(CommandType.DROP);
        this.itemName = itemName;
    }

    @Override
    public String execute(GameState gameState) {
        Player player = gameState.getPlayer();
        Room currentRoom = gameState.getMap().getCurrentRoom();

        // Check for item in player's inventory
        if (player.hasItem(itemName)) {
            Item itemToDrop = player.getItem(itemName);
            player.removeItem(itemToDrop);
            currentRoom.addItem(itemToDrop);
            return "You drop: " + itemName;
        }
        
        // Check for equipment in player's inventory
        if (player.hasEquipment(itemName)) {
            Equipment equipmentToDrop = player.getEquipment(itemName);
            player.getEquipment().remove(equipmentToDrop);
            currentRoom.addEquipment(equipmentToDrop);
            return "You drop: " + itemName;
        }

        // If item is not in player's inventory
        return "You cannot drop " + itemName;
    }

    public String getItemName() {
        return itemName;
    }
}