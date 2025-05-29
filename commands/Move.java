//package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Move extends Command {
    private String direction;

    public Move(String direction) {
        super(CommandType.MOVE);
        this.direction = direction;
    }

    @Override
    public String execute(GameState gameState) {
        // Get the current room from the map
        Room currentRoom = gameState.getMap().getCurrentRoom();
        
        // Check for exit in the specified direction
        Exit exit = currentRoom.getExit(direction);
        
        // If no exit exists or exit is hidden, return "No exit found" message
        if (exit == null || exit.isHidden()) {
            return "No exit found in that direction.";
        }
        
        // Get the destination room ID
        String destinationRoomId = exit.getDestinationRoomId();
        
        // Update the current room in the game map
        gameState.getMap().setCurrentRoom(destinationRoomId);
        
        // Return move confirmation message with newline
        return "Moving towards " + direction + "\n";
    }

    @Override
    public String toString() {
        return "move " + direction;
    }

    // Getter for direction
    public String getDirection() {
        return direction;
    }
}