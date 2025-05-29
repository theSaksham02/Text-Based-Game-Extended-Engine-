//package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameState {
    private Player player;
    private Room currentRoom;
    private Map gameMap;
    private List<Item> discoveredItems;
    private int score; 
    private int itemCollectionScore; 
    private int roomExplorationScore; 
    private boolean isGameRunning;

    // Default constructor
    public GameState() {
        this.player = null;
        this.gameMap = null;
        this.currentRoom = null;
        this.discoveredItems = new ArrayList<>();
        this.score = 0;
        this.itemCollectionScore = 0;
        this.roomExplorationScore = 0;
        this.isGameRunning = true;
    }

    // Parameterized constructor
    public GameState(Map gameMap, Player player) {
        this.gameMap = gameMap;
        this.player = player;
        this.currentRoom = gameMap != null ? gameMap.getCurrentRoom() : null;
        this.discoveredItems = new ArrayList<>();
        this.score = 0;
        this.itemCollectionScore = 0;
        this.roomExplorationScore = 0;
        this.isGameRunning = true;
    }

    // Getters and Setters
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        if (this.gameMap != null) {
            this.gameMap.setCurrentRoom(currentRoom);
        }
    }

    public Map getGameMap() {
        return this.gameMap;
    }

    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    // Alias methods to match different naming conventions
    public Map getMap() {
        return this.gameMap;
    }

    public void setMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public List<Item> getDiscoveredItems() {
        return discoveredItems;
    }

    public void addDiscoveredItem(Item item) {
        if (!discoveredItems.contains(item)) {
            discoveredItems.add(item);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getItemCollectionScore() {
        return itemCollectionScore;
    }

    public void setItemCollectionScore(int itemCollectionScore) {
        this.itemCollectionScore = itemCollectionScore;
    }

    public int getRoomExplorationScore() {
        return roomExplorationScore;
    }

    public void setRoomExplorationScore(int roomExplorationScore) {
        this.roomExplorationScore = roomExplorationScore;
    }

    public boolean isGameRunning() {
        return this.isGameRunning;
    }

    public void quitGame() {
        this.isGameRunning = false;
    }

    // Utility methods
    public void updateScore(int points) {
        this.score += points;
    }

    public void updateItemCollectionScore(int points) {
        this.itemCollectionScore += points;
    }

    public void updateRoomExplorationScore(int points) {
        this.roomExplorationScore += points;
    }

    // Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return score == gameState.score &&
               itemCollectionScore == gameState.itemCollectionScore &&
               roomExplorationScore == gameState.roomExplorationScore &&
               isGameRunning == gameState.isGameRunning &&
               Objects.equals(player, gameState.player) &&
               Objects.equals(currentRoom, gameState.currentRoom) &&
               Objects.equals(gameMap, gameState.gameMap) &&
               Objects.equals(discoveredItems, gameState.discoveredItems);
    }

    // HashCode method
    @Override
    public int hashCode() {
        return Objects.hash(player, currentRoom, gameMap, discoveredItems, 
                            score, itemCollectionScore, roomExplorationScore, isGameRunning);
    }

    // ToString method
    @Override
    public String toString() {
        return "GameState{" +
                "player=" + player +
                ", map=" + gameMap +
                ", currentRoom=" + currentRoom +
                ", discoveredItems=" + discoveredItems +
                ", score=" + score +
                ", itemCollectionScore=" + itemCollectionScore +
                ", roomExplorationScore=" + roomExplorationScore +
                ", isGameRunning=" + isGameRunning +
                '}';
    }
}