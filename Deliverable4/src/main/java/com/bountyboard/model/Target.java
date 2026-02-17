package com.bountyboard.model;

/**
 * Domain model for Target entity.
 * A target is a character with a bounty value and last known location.
 */
public class Target {
    private int targetId; // References Character.CharacterID
    private int value;
    private Integer lastLocationPlanetId; // Can be null
    
    public Target() {
    }
    
    public Target(int targetId, int value, Integer lastLocationPlanetId) {
        this.targetId = targetId;
        this.value = value;
        this.lastLocationPlanetId = lastLocationPlanetId;
    }
    
    public int getTargetId() {
        return targetId;
    }
    
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Integer getLastLocationPlanetId() {
        return lastLocationPlanetId;
    }
    
    public void setLastLocationPlanetId(Integer lastLocationPlanetId) {
        this.lastLocationPlanetId = lastLocationPlanetId;
    }
}
