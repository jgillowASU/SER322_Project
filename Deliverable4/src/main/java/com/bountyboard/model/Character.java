package com.bountyboard.model;

/**
 * Domain model for Character entity.
 */
public class Character {
    private int characterId;
    private String name;
    
    // TODO: Add constructors, getters, and setters
    
    public Character() {
    }
    
    public Character(int characterId, String name) {
        this.characterId = characterId;
        this.name = name;
    }
    
    // Getters and setters
    public int getCharacterId() {
        return characterId;
    }
    
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
