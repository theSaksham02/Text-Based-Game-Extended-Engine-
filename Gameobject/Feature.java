//package org.uob.a2.gameobjects;

public class Feature extends GameObject {
    private boolean hidden; 

    public Feature() {
        super();
        this.hidden = false; // Features are visible by default
    }

    public Feature(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    // Add this method to match the test case
    public boolean getHidden() {
        return hidden;
    }

    public boolean canInteractWith(Item item) {
        return true;
    }

    public void interact(Item item, GameState gameState) {
        // Empty implementation
    }

    @Override
    public String toString() {
        return String.format("GameObject {id='%s', name='%s', description='%s', hidden=%b}", 
            getId(), getName(), getDescription(), hidden);
    }
}