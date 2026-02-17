package com.bountyboard.model;

/**
 * Domain model for BountyHunter entity.
 * A bounty hunter is a character with credits.
 */
public class BountyHunter {
    private int bountyHunterId; // References Character.CharacterID
    private int credits;
    
    public BountyHunter() {
    }
    
    public BountyHunter(int bountyHunterId, int credits) {
        this.bountyHunterId = bountyHunterId;
        this.credits = credits;
    }
    
    public int getBountyHunterId() {
        return bountyHunterId;
    }
    
    public void setBountyHunterId(int bountyHunterId) {
        this.bountyHunterId = bountyHunterId;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
}
