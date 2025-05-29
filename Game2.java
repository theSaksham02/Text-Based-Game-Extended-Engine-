//package org.uob.a2;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

import java.io.File;
import java.util.Scanner;

public class Game {
    private GameState gameState;
    private Tokeniser tokeniser;
    private Parser parser;
    private int totalScore;
    private int roomExplorationScore;
    private int itemCollectionScore;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        // Load game state from file
        String gameStateFilePath = "data/game.txt";
        gameState = GameStateFileParser.parse(gameStateFilePath);
        
        tokeniser = new Tokeniser();
        parser = new Parser();
        
        // Initialize scores
        totalScore = 0;
        roomExplorationScore = 0;
        itemCollectionScore = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Adventure Game!");
        System.out.println(gameState.getMap().getCurrentRoom().getDescription());

        while (gameState.isGameRunning()) {
            try {
                System.out.print("--> ");
                String input = scanner.nextLine();
                
                // Tokenize and parse input
                java.util.List<Token> tokens = tokeniser.tokenise(input);
                Command command = parser.parse(tokens);
                
                // Execute command and print result
                String result = command.execute(gameState);
                System.out.println(result);
                
                // Update scores based on game actions
                updateScores(command);
            } catch (CommandErrorException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private void updateScores(Command command) {
        // Score update logic
        switch (command.commandType) {
            case MOVE:
                roomExplorationScore += 10;
                break;
            case GET:
                itemCollectionScore += 20;
                break;
            case USE:
                totalScore += 15;
                break;
        }
        
        // Recalculate total score
        totalScore = roomExplorationScore + itemCollectionScore;
    }

    // New method to display map
    public String displayMap() {
        StringBuilder mapDisplay = new StringBuilder("Game Map:\n");
        for (Room room : gameState.getMap().getRooms()) {
            mapDisplay.append(room.getName())
                      .append(" (")
                      .append(room.getId())
                      .append(")\n");
            for (Exit exit : room.getExits()) {
                mapDisplay.append("  → ")
                          .append(exit.getDirection())
                          .append(": ")
                          .append(exit.getNextRoom())
                          .append("\n");
            }
        }
        return mapDisplay.toString();
    }

    // New method to display score
    public String displayScore() {
        return String.format(
            "Score Details:\n" +
            "Total Score: %d\n" +
            "Room Exploration Score: %d\n" +
            "Item Collection Score: %d",
            totalScore, roomExplorationScore, itemCollectionScore
        );
    }

    // Method to combine items
    public Item combineItems(Item item1, Item item2) {
        // Example combination logic
        if (item1.getName().equals("stick") && item2.getName().equals("rock")) {
            return new Item("weapon", "Stone Hammer", "A primitive weapon made from a stick and a rock", false);
        }
        // Add more combination rules as needed
        return null;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}