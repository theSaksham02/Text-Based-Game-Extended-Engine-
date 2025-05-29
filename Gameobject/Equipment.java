//package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {
    private UseInformation useInformation;

    // Default constructor
    public Equipment() {
        super();
        this.useInformation = new UseInformation();
    }

    // Parameterized constructor
    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation) {
        super(id, name, description, hidden);
        this.useInformation = useInformation != null ? useInformation : new UseInformation();
    }

        @Override
    public String use(Container target, GameState gameState) {
        // Validate target and use information
        if (target == null || useInformation == null) {
            return "";
        }
    
        // Check if already used
        if (useInformation.isUsed()) {
            return useInformation.getMessage();
        }
    
        // Check if target matches expected target
        if (useInformation.getTargetId() != null && 
            !useInformation.getTargetId().equalsIgnoreCase(target.getId())) {
            return "";
        }
    
        // Reveal hidden items in the current room
        Room currentRoom = gameState.getCurrentRoom();
        for (Item item : currentRoom.getItems()) {
            if (item.isHidden()) {
                item.setHidden(false);
            }
        }
    
        // Mark as used and return message
        useInformation.setSuccess(true);
        useInformation.setUsed(true);
        return useInformation.getMessage();
    }
    // Usable interface methods
    @Override
    public UseInformation getUseInformation() {
        return useInformation;
    }

    @Override
    public void setUseInformation(UseInformation useInformation) {
        this.useInformation = useInformation;
    }

    // Override getName to ensure interface compliance
    @Override
    public String getName() {
        return super.getName();
    }

    // Additional utility methods
    public boolean getHidden() {
        return super.isHidden();
    }

    @Override
    public String toString() {
        return super.toString() + ", UseInfo: " + useInformation;
    }
}