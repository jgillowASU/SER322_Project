package com.bountyboard.model;

/**
 * Domain model for Planet entity.
 */
public class Planet {
    private int planetId;
    private String name;
    
    public Planet() {
    }
    
    public Planet(int planetId, String name) {
        this.planetId = planetId;
        this.name = name;
    }
    
    public int getPlanetId() {
        return planetId;
    }
    
    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
