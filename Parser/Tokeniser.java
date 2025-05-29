//package org.uob.a2.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.uob.a2.commands.Command;
import org.uob.a2.gameobjects.GameState;

public class Tokeniser {
    private List<Token> tokens;

    // Existing methods remain the same...

    // New method to start game loop
    public void startGame() {
        // Create a default game state
        GameState gameState = createDefaultGameState();
        
        // Use system input for game interaction
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        
        System.out.println("Welcome to the Adventure Game!");
        
        // Main game loop
        while (gameState.isGameRunning()) {
            try {
                // Prompt for input
                System.out.print(">> ");
                String input = scanner.nextLine();
                
                // Tokenize and parse input
                List<Token> tokens = this.tokenise(input);
                Command command = parser.parse(tokens);
                
                // Execute command
                String result = command.execute(gameState);
                System.out.println(result);
                
                // Check for quit condition
                if (command.commandType == CommandType.QUIT) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    // Helper method to create a default game state
    private GameState createDefaultGameState() {
        // Create a basic map
        Map gameMap = new Map();
        
        // Create a start room
        Room startRoom = new Room("start_room", "Starting Room", "A dimly lit room with ancient walls.", false);
        gameMap.addRoom(startRoom);
        gameMap.setCurrentRoom(startRoom);
        
        // Create a player
        Player player = new Player("Adventurer");
        
        // Create game state
        return new GameState(gameMap, player);
    }

    // Optional: Add a main method for direct execution
    public static void main(String[] args) {
        new Tokeniser().startGame();
    }
}