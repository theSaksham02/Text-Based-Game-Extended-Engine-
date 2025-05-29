//package org.uob.a2.gameobjects;

/**
 * Represents an interface for objects that can be used within the game.
 * 
 * <p>
 * Objects implementing this interface must define methods to manage their use
 * information and provide their name.
 * </p>
 */

public interface Usable {
    UseInformation getUseInformation();
    void setUseInformation(UseInformation useInformation);
    String getName();
    
    default String use(Container target, GameState gameState) {
        UseInformation useInfo = getUseInformation();
        if (useInfo.isSuccess()) {
            return useInfo.getMessage(); // Return success message
        } else {
            return "You cannot use this item here."; // Default message
        }
    }
}