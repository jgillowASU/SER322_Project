package com.bountyboard.model;

/**
 * Domain model for Contract entity.
 */
public class Contract {
    private int contractId;
    private int syndicateId;
    private int targetId;
    private Integer bountyHunterId; // Can be null
    private CompletionStatus completionStatus;
    
    public enum CompletionStatus {
        Pending, Completed, Failed
    }
    
    public Contract() {
    }
    
    public Contract(int contractId, int syndicateId, int targetId, 
                   Integer bountyHunterId, CompletionStatus completionStatus) {
        this.contractId = contractId;
        this.syndicateId = syndicateId;
        this.targetId = targetId;
        this.bountyHunterId = bountyHunterId;
        this.completionStatus = completionStatus;
    }
    
    public int getContractId() {
        return contractId;
    }
    
    public void setContractId(int contractId) {
        this.contractId = contractId;
    }
    
    public int getSyndicateId() {
        return syndicateId;
    }
    
    public void setSyndicateId(int syndicateId) {
        this.syndicateId = syndicateId;
    }
    
    public int getTargetId() {
        return targetId;
    }
    
    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
    
    public Integer getBountyHunterId() {
        return bountyHunterId;
    }
    
    public void setBountyHunterId(Integer bountyHunterId) {
        this.bountyHunterId = bountyHunterId;
    }
    
    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }
    
    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }
}
