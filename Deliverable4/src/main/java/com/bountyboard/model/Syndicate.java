package com.bountyboard.model;

/**
 * Domain model for Syndicate entity.
 */
public class Syndicate {
    private int syndicateId;
    private String name;
    
    public Syndicate() {
    }
    
    public Syndicate(int syndicateId, String name) {
        this.syndicateId = syndicateId;
        this.name = name;
    }
    
    public int getSyndicateId() {
        return syndicateId;
    }
    
    public void setSyndicateId(int syndicateId) {
        this.syndicateId = syndicateId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
