//package org.uob.a2.parser;

/**
 * Represents the types of tokens that can be identified and processed by the parser.
 * 
 * <p>
 * Each {@code TokenType} corresponds to a specific category of input, such as a command,
 * variable, or special symbol. These token types are used during the tokenisation and parsing process.
 * </p>
 */
public enum TokenType {
    USE,        // Represents the "use" command.
    GET,        // Represents the "get" command.
    DROP,       // Represents the "drop" command.
    LOOK,       // Represents the "look" command.
    STATUS,     // Represents the "status" command.
    HELP,       // Represents the "help" command.
    QUIT,       // Represents the "quit" command.
    ERROR,      // Represents an error token, typically for invalid input.
    VAR,        // Represents a variable or unclassified word.
    MOVE,       // Represents the "move" command.
    PREPOSITION, // Represents a preposition such as "on", "with", or "using".
    EOL,        // Represents the end of a line or command.
    COMMAND,// Represents a command token.
    COMBINE, 
    NOUN;       // Represents a noun token.
}