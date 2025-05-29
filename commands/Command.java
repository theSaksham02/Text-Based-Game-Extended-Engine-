//package org.uob.a2.commands;

//import org.uob.a2.gameobjects.GameState;

public abstract class Command {
    // Make these public to match the test expectations
    public CommandType commandType;
    public String value;

    // Default constructor
    public Command() {}

    // Constructor to set commandType
    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    // Method to match the test's execution expectation
    public String execute(GameState gameState) {
        // Default implementation that can be overridden by subclasses
        return "Command executed";
    }
    public void setValue(String value) {
    this.value = value;
}
}