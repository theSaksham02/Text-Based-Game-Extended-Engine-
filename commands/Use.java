//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.*;

public class Use extends Command {
    private String itemName;
    private String targetName;

    public Use(String itemName, String targetName) {
        super(CommandType.USE);
        this.itemName = itemName;
        this.targetName = targetName;
    }

    @Override
        public String execute(GameState gameState) {
            Player player = gameState.getPlayer();
            Room currentRoom = gameState.getMap().getCurrentRoom();
        
            // Check if player owns the equipment
            Equipment equipment = null;
            for (Equipment eq : player.getEquipment()) {
                if (eq.getName().equalsIgnoreCase(itemName)) {
                    equipment = eq;
                    break;
                }
            }
        
            if (equipment == null) {
                return "You do not have " + itemName;
            }
        
            // Check if equipment is already used
            UseInformation useInfo = equipment.getUseInformation();
            if (useInfo != null && useInfo.isUsed()) {
                return "You have already used " + itemName;
            }
        
            // Find the target in the room
            Container target = null;
            for (Feature feature : currentRoom.getFeatures()) {
                if (feature instanceof Container && 
                    feature.getName().equalsIgnoreCase(targetName)) {
                    target = (Container) feature;
                    break;
                }
            }
        
            // Validate target
            if (target == null) {
                return "Invalid use target";
            }
        
            // Attempt to use the equipment
            String result = equipment.use(target, gameState);
            
            // If result is empty, provide a default success message
            return result.isEmpty() ? "Successfully used " + itemName + " on " + targetName : result;
        }

    @Override
    public String toString() {
        return itemName + (targetName != null ? " on " + targetName : "");
    }
}