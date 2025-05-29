//package org.uob.a2.utils;

import org.uob.a2.gameobjects.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameStateFileParser {
    public static GameState parse(String filePath) {
        // Ensure GameState is initialized with a new Map and Player
        GameState gameState = new GameState(new Map(), new Player());
        Room currentRoom = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty() || line.startsWith("#")) continue;

                int colonIndex = line.indexOf(':');
                if (colonIndex == -1) continue;

                String key = line.substring(0, colonIndex).trim();
                String value = line.substring(colonIndex + 1).trim();

                switch (key) {
                    case "player":
                        gameState.setPlayer(new Player(value));
                        break;
                    
                    case "map":
                        // Ensure map is initialized before setting current room
                        if (gameState.getMap() == null) {
                            gameState.setMap(new Map());
                        }
                        gameState.getMap().setCurrentRoomById(value);
                        break;
                    
                    case "room":
                        String[] roomDetails = value.split(",");
                        if (roomDetails.length >= 4) {
                            currentRoom = new Room(
                                roomDetails[0].trim(), 
                                roomDetails[1].trim(), 
                                roomDetails[2].trim(), 
                                Boolean.parseBoolean(roomDetails[3].trim())
                            );
                            // Ensure map is initialized
                            if (gameState.getMap() == null) {
                                gameState.setMap(new Map());
                            }
                            gameState.getMap().addRoom(currentRoom);
                            gameState.getMap().setCurrentRoom(currentRoom);
                        }
                        break;
                    
                    case "item":
                        if (currentRoom != null) {
                            String[] itemDetails = value.split(",");
                            if (itemDetails.length >= 4) {
                                Item item = new Item(
                                    itemDetails[0].trim(), 
                                    itemDetails[1].trim(), 
                                    itemDetails[2].trim(), 
                                    Boolean.parseBoolean(itemDetails[3].trim())
                                );
                                currentRoom.addItem(item);
                            }
                        }
                        break;
                    
                    case "equipment":
                        if (currentRoom != null) {
                            String[] equipDetails = value.split(",");
                            if (equipDetails.length >= 7) {
                                UseInformation useInfo = new UseInformation(
                                    equipDetails[4].trim(), 
                                    equipDetails[5].trim(), 
                                    equipDetails[6].trim(), 
                                    ""
                                );
                                Equipment equipment = new Equipment(
                                    equipDetails[0].trim(), 
                                    equipDetails[1].trim(), 
                                    equipDetails[2].trim(), 
                                    Boolean.parseBoolean(equipDetails[3].trim()), 
                                    useInfo
                                );
                                currentRoom.addEquipment(equipment);
                            }
                        }
                        break;
                    
                    case "container":
                        if (currentRoom != null) {
                            String[] containerDetails = value.split(",");
                            if (containerDetails.length >= 4) {
                                Feature feature = new Feature(
                                    containerDetails[0].trim(), 
                                    containerDetails[1].trim(), 
                                    containerDetails[2].trim(), 
                                    Boolean.parseBoolean(containerDetails[3].trim())
                                );
                                currentRoom.addFeature(feature);
                            }
                        }
                        break;
                    
                    case "exit":
                        if (currentRoom != null) {
                            String[] exitDetails = value.split(",");
                            if (exitDetails.length >= 5) {
                                Exit exit = new Exit(
                                    exitDetails[0].trim(),  // id
                                    exitDetails[1].trim(),  // name
                                    exitDetails[2].trim(),  // description
                                    exitDetails[3].trim(),  // destination room
                                    Boolean.parseBoolean(exitDetails[4].trim())  // is locked
                                );
                                currentRoom.addExit(exit);
                            }
                        }
                        break;
                }
            }
        } catch (IOException e) {
            // Log error or handle appropriately
            System.err.println("Error reading game state file: " + e.getMessage());
        }

        return gameState;
    }
}