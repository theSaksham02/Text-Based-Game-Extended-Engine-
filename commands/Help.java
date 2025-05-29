//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {
    private String topic;

    // No-argument constructor
    public Help() {
        super(CommandType.HELP);
        this.topic = null;
    }

    // Constructor with topic
    public Help(String topic) {
        super(CommandType.HELP);
        this.topic = topic;
    }

    @Override
    public String execute(GameState gameState) {
        if (topic == null) {
            // General help
            return "Welcome to the game!\n" +
                   "Available commands:\n" +
                   "- MOVE\n" +
                   "- HELP\n" +
                   "- LOOK\n" +
                   "- GET\n" +
                   "- DROP\n" +
                   "- USE\n" +
                   "Type 'help <command>' for more information about a specific command.";
        }

        // Specific help based on topic
        switch (topic.toLowerCase()) {
            case "move":
                return "MOVE Command:\n" +
                       "Use the 'move' command to navigate between rooms.\n" +
                       "Use the 'move' command followed by a direction (north, south, east, west).";
            case "look":
                return "LOOK Command:\n" +
                       "Use the 'look' command to examine the current room.\n" +
                       "Provides a description of the current room and its contents.";
            default:
                return "No help available for the topic: " + topic;
        }
    }

    @Override
public String toString() {
    return "HELP" + (topic != null ? " " + topic : " null");
}
}