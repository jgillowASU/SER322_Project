package com.bountyboard.dao;

import java.sql.*;

public class BountyBoardService {
    private final Connection connection;

    public BountyBoardService(Connection connection) {
        this.connection = connection;
    }

    // For lists to select from---

    public void printSyndicates() {
        // TODO
    }

    public void printTargets() {
        // TODO
    }

    public void printHunters() {
        // TODO
    }

    // ---------

    // --- For everyone ----

    public void printBountyBoard() {
        // TODO
    }

    public void printUnassignedBounties() {
        // TODO
    }

    public void printUnfinishedBounties() {
        // TODO
    }

    public void printBountiesAssignedToHunter(int hunterId) {
        // TODO
    }


    // Syndicate stuff ------

    public void createBounty(int syndicateId, int targetId) {
        // TODO
    }

    public void deleteBountyIfNotCompleted(int contractId) {
        // TODO
    }

    // --------


    // Bounty hunter stuff --------------
    public void claimBounty(int contractId, int hunterId) {
        // TODO
    }

    public void setCompleted(int contractId, int hunterId) {
        // TODO
    }

    // ----- helpers
    public boolean syndicateExists(int id) {
        return exists("SELECT 1 FROM SYNDICATE WHERE SyndicateID = ?", id);
    }

    public boolean targetExists(int id) {
        return exists("SELECT 1 FROM TARGET WHERE TargetID = ?", id);
    }

    public boolean hunterExists(int id) {
        return exists("SELECT 1 FROM BOUNTY_HUNTER WHERE BountyHunterID = ?", id);
    }

    private boolean exists(String sql, int id) {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }
}

