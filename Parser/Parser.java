//package org.uob.a2.parser;
import java.util.List; 
import org.uob.a2.commands.*; 
import org.uob.a2.gameobjects.Item;

public class Parser {
    public Command parse(List<Token> tokens) throws CommandErrorException {
        if (tokens.isEmpty()) {
            throw new CommandErrorException("No command entered.");
        }

        Token firstToken = tokens.get(0);
        TokenType firstTokenType = firstToken.getTokenType();
        
        switch (firstTokenType) {
            case MOVE:
                return parseMove(tokens);
            case LOOK:
                return parseLook(tokens);
            case GET:
                return parseGet(tokens);
            case DROP:
                return parseDrop(tokens);
            case USE:
                return parseUse(tokens);
            case STATUS:
                return parseStatus(tokens);
            case HELP:
                return parseHelp(tokens);
            case QUIT:
                return parseQuit(tokens);
            /*case COMBINE:
                return parseCombine(tokens);*/
            default:
                throw new CommandErrorException("Invalid Command: " + firstTokenType);
        }
    }

    private Move parseMove(List<Token> tokens) throws CommandErrorException {
    if (tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR) {
        throw new CommandErrorException("Move command requires a direction.");
    }
    String direction = tokens.get(1).getValue();
    Move move = new Move(direction);
    move.setValue(direction); // Ensure value is set
    move.commandType = CommandType.MOVE; // Explicitly set command type
    return move;
}
     
    private Look parseLook(List<Token> tokens) {
    Look look = new Look();
    
    // If there's more than one token and the second token is a VAR
    if (tokens.size() > 1 && tokens.get(1).getTokenType() == TokenType.VAR) {
        // Set the value to the second token's value
        look.setValue(tokens.get(1).getValue());
    }
    
    return look;
}
     
    private Get parseGet(List<Token> tokens) throws CommandErrorException {
    if (tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR) {
        throw new CommandErrorException("Get command requires an item name");
    }

    String itemName = tokens.get(1).getValue();
    Get get = new Get(itemName);
    get.setValue(itemName); // Ensure value is set
    get.commandType = CommandType.GET; // Explicitly set command type
    return get;
}

    private Drop parseDrop(List<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2 || tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Drop command requires an item name");
        }
        String itemName = tokens.get(1).getValue();
        Drop drop = new Drop(itemName);
        drop.setValue(itemName); // Ensure value is set
        return drop;
    }

    private Use parseUse(List<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Use command requires an item name.");
        }
        
        String itemName = tokens.get(1).getValue();
        String targetName = null; 
        
        // Comprehensive check for 'on' preposition and target
        if (tokens.size() >= 4 && 
            tokens.get(2).getTokenType() == TokenType.PREPOSITION && 
            tokens.get(3).getTokenType() == TokenType.VAR) {
            targetName = tokens.get(3).getValue();
        }        
        
        Use use = new Use(itemName, targetName);
        use.setValue(itemName + (targetName != null ? " on " + targetName : "")); 
        return use;
    }

    private Status parseStatus(List<Token> tokens) {
        Status status = new Status();
        if (tokens.size() > 1 && tokens.get(1).getTokenType() == TokenType.VAR) {
            status.setValue(tokens.get(1).getValue());
        }
        return status;
    }

    private Help parseHelp(List<Token> tokens) {
        Help help = new Help();
        // If a specific help topic is provided
        if (tokens.size() > 1 && tokens.get(1).getTokenType() == TokenType.VAR) {
            help.setValue(tokens.get(1).getValue());
        }
        return help;
    }

    private Quit parseQuit(List<Token> tokens) {
        Quit quit = new Quit();
        return quit;
    }

    /*private Command parseCombine(List<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 4 || 
            tokens.get(2).getTokenType() != TokenType.PREPOSITION || 
            tokens.get(1).getTokenType() != TokenType.VAR || 
            tokens.get(3).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Combine command requires two items: 'combine item1 and item2'");
        } 
        
        String item1 = tokens.get(1).getValue();
        String item2 = tokens.get(3).getValue();
        
        Combine combine = new Combine(item1, item2);
        combine.setValue(item1 + " and " + item2);
        return combine;
    } */
}