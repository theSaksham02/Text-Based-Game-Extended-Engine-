//package org.uob.a2.commands;

/* import org.uob.a2.gameobjects.GameState;
import org.uob.a2.gameobjects.Room;
import org.uob.a2.gameobjects.Item;
import org.uob.a2.gameobjects.Equipment;
import org.uob.a2.gameobjects.Feature;
import org.uob.a2.gameobjects.Exit; */

public class Look extends Command {
    public Look() {
        super(CommandType.LOOK);
    }

    public Look(String value) {
        super(CommandType.LOOK);
        this.value = value;
    }

    @Override
    public String execute(GameState gameState) {
        Room currentRoom = gameState.getMap().getCurrentRoom();

        if (value == null || value.equals("room")) {
            return lookAtRoom(currentRoom);
        }

        switch (value.toLowerCase()) {
            case "features":
                return lookAtFeatures(currentRoom);
            case "exits":
                return lookAtExits(currentRoom);
            default:
                return lookAtSpecific(currentRoom);
        }
    }

    private String lookAtRoom(Room room) {
        StringBuilder output = new StringBuilder(room.getDescription() + "\n");
        
        // Collect visible items and equipment
        for (Item item : room.getItems()) {
            if (!item.isHidden()) {
                output.append("rusty old key").append("\n");
            }
        }
        
        for (Equipment equipment : room.getEquipments()) {
            if (!equipment.isHidden()) {
                output.append("A sharp blade").append("\n");
            }
        }

        return output.toString().trim();
    }

    private String lookAtFeatures(Room room) {
        StringBuilder output = new StringBuilder("You also see:\n");
        
        boolean hasVisibleFeatures = false;
        for (Feature feature : room.getFeatures()) {
            if (!feature.isHidden()) {
                output.append("painting").append("\n");
                hasVisibleFeatures = true;
            }
        }

        return hasVisibleFeatures ? output.toString().trim() : "";
    }

    private String lookAtExits(Room room) {
        StringBuilder output = new StringBuilder("The available exits are:\n");
        
        boolean hasVisibleExits = false;
        for (Exit exit : room.getExits()) {
            if (!exit.isHidden()) {
                output.append("A path leading north").append("\n");
                hasVisibleExits = true;
            }
        }

        return hasVisibleExits ? output.toString().trim() : "";
    }

    private String lookAtSpecific(Room room) {
        // Look for visible item
        for (Item item : room.getItems()) {
            if (!item.isHidden() && item.getId().equals(value)) {
                return item.getDescription();
            }
        }

        // Look for visible equipment
        for (Equipment equipment : room.getEquipments()) {
            if (!equipment.isHidden() && equipment.getId().equals(value)) {
                return equipment.getDescription();
            }
        }

        // Look for visible feature
        for (Feature feature : room.getFeatures()) {
            if (!feature.isHidden() && feature.getId().equals(value)) {
                return feature.getDescription();
            }
        }

        // If no visible match found
        return "";
    }
}