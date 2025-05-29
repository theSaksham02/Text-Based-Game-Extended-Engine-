//package org.uob.a2.gameobjects;

/**
 * Represents an exit in the game, connecting rooms and inheriting from GameObject.
 */
public class Exit extends GameObject {
    private String nextRoom;
    private String direction;
    private boolean isLocked;

    /**
     * Default constructor initializing an empty Exit.
     */
    public Exit() {
        super();
        this.nextRoom = "";
        this.direction = "";
        this.isLocked = false;
    }

    /**
     * Comprehensive constructor for creating an Exit.
     *
     * @param id The unique identifier for the exit
     * @param name The name of the exit
     * @param description A description of the exit
     * @param nextRoom The ID of the room this exit leads to
     * @param hidden Whether the exit is hidden
     */
    public Exit(String id, String name, String description, String nextRoom, boolean hidden) {
        super(id, name, description, hidden);
        this.nextRoom = nextRoom;
        this.direction = id;
        this.isLocked = false;
    }

    /**
     * Constructor for minimal exit details
     *
     * @param direction The direction of the exit
     * @param targetRoomId The ID of the room this exit leads to
     * @param description A description of the exit
     */
    public Exit(String direction, String targetRoomId, String description) {
        super(direction, direction + " Exit", description, false);
        this.direction = direction;
        this.nextRoom = targetRoomId;
        this.isLocked = false;
    }

    /**
     * Gets the ID of the next room this exit leads to.
     *
     * @return The next room's ID
     */
    public String getNextRoom() {
        return this.nextRoom;
    }

    /**
     * Sets the ID of the next room for this exit.
     *
     * @param nextRoom The ID of the room to set as the next room
     */
    public void setNextRoom(String nextRoom) {
        this.nextRoom = nextRoom;
    }

    /**
     * Gets the direction of the exit.
     *
     * @return The direction of the exit
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the exit.
     *
     * @param direction The new direction for the exit
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Gets the destination room ID (alias for getNextRoom).
     *
     * @return The ID of the room this exit leads to
     */
    public String getDestinationRoomId() {
        return nextRoom;
    }

    /**
     * Checks if the exit is locked.
     *
     * @return true if the exit is locked, false otherwise
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Sets the locked status of the exit.
     *
     * @param locked The new locked status
     */
    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }

    /**
     * Gets the hidden status of the exit.
     *
     * @return true if the exit is hidden, false otherwise
     */
    public boolean getHidden() {
        return super.isHidden();
    }

    /**
     * Provides a string representation of the Exit.
     *
     * @return A string describing the exit with its GameObject properties and next room
     */
    @Override
    public String toString() {
        return super.toString() + ", nextRoom=" + nextRoom;
    }

    @Override
    public void setHidden(boolean hidden) {
        super.setHidden(hidden);
    }
    /**
     * Compares this exit to another object for equality.
     *
     * @param o The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exit)) return false;
        if (!super.equals(o)) return false;
        
        Exit exit = (Exit) o;
        
        if (isLocked != exit.isLocked) return false;
        if (direction != null ? !direction.equals(exit.direction) : exit.direction != null) return false;
        return nextRoom != null ? nextRoom.equals(exit.nextRoom) : exit.nextRoom == null;
    }

    /**
     * Generates a hash code for the exit.
     *
     * @return A hash code value for the exit
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (nextRoom != null ? nextRoom.hashCode() : 0);
        result = 31 * result + (isLocked ? 1 : 0);
        return result;
    }
}