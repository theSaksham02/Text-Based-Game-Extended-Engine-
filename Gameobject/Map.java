//package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p> 
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    private ArrayList<Room> rooms; // List to hold all rooms in the map
    private Room currentRoom; // The room the player is currently in

    // Default constructor
    public Map() {
        this.rooms = new ArrayList<>();
        this.currentRoom = null; // Initialize currentRoom to null
    }

    // Method to add a room to the map
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Method to set the current room by Room object
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    // Method to get the current room
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    // Method to set the current room by room ID
    public void setCurrentRoom(String roomId) {
        for (Room room : rooms) {
            if (room.getId().equals(roomId)) {
                this.currentRoom = room;
                return;
            }
        }
        // If no room found, do not change currentRoom (keep it null)
    }

    // Method to set the current room by room ID (newly added)
    public void setCurrentRoomById(String roomId) {
        setCurrentRoom(roomId); // Reuse the existing method
    }

    // Method to get the list of rooms in the map
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    // Method to get explored rooms (to be implemented)
    public List<Room> getExploredRooms() {
        List<Room> exploredRooms = new ArrayList<>();
        // Logic to determine explored rooms can be added here
        return exploredRooms;
    }

    // Method to get all rooms (to be implemented)
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    // Method to get unvisited rooms (to be implemented)
    public List<Room> getUnvisitedRooms() {
        List<Room> unvisitedRooms = new ArrayList<>();
        // Logic to determine unvisited rooms can be added here
        return unvisitedRooms;
    }

    // Method to get a room by its ID
    public Room getRoomById(String roomId) {
        for (Room room : rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }
        return null; 
    }

    // Method to move to the next room based on direction
    public Room moveToNextRoom(Room currentRoom, String direction) {
        String destinationRoomId = currentRoom.getExitDestination(direction);
        if (destinationRoomId != null) {
            Room nextRoom = getRoomById(destinationRoomId);
            if (nextRoom != null) {
                setCurrentRoom(nextRoom);
                return nextRoom;
            }
        }
        return null; 
    }

    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}