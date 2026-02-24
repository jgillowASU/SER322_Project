package com.bountyboard.dao;

import com.bountyboard.ui.util.ResultFormatter;

import java.sql.*;

public class BountyBoardService {
    private final Connection connection;

    public BountyBoardService(Connection connection) {
        this.connection = connection;
    }

    // For lists to select from---

    public void printSyndicates() {
        String sql = "SELECT SyndicateID, Name FROM SYNDICATE ORDER BY Name";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultFormatter.printResultSet(rs);
        } catch (SQLException e) {
            ResultFormatter.printError("Error in syndicates: " + e.getMessage());
        }
    }

    public void printTargets() {
        String sql =
                "SELECT t.TargetID, c.Name, t.Value " +
                        "FROM TARGET t " +
                        "JOIN `CHARACTER` c ON c.CharacterID = t.TargetID " +
                        "ORDER BY t.Value DESC, c.Name";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultFormatter.printResultSet(rs);
        } catch (SQLException e) {
            ResultFormatter.printError("Error in targets: " + e.getMessage());
        }
    }

    public void printBountyHunters() {
        String sql =
                "SELECT bh.BountyHunterID, c.Name, bh.Credits " +
                        "FROM BOUNTY_HUNTER bh " +
                        "JOIN `CHARACTER` c ON c.CharacterID = bh.BountyHunterID " +
                        "ORDER BY c.Name";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultFormatter.printResultSet(rs);
        } catch (SQLException e) {
            ResultFormatter.printError("Error in bounty hunters: " + e.getMessage());
        }
    }

    // ---------

    // --- For everyone ----

    public void printBountyBoard() {
        String sql =
                "SELECT s.Name AS Syndicate, tc.Name AS TargetName, hc.Name AS HunterName, " +
                        "co.CompletionStatus, t.Value, p.Name AS LastSeenPlanet " +
                        "FROM CONTRACT co " +
                        "JOIN SYNDICATE s ON s.SyndicateID = co.SyndicateID " +
                        "JOIN TARGET t ON t.TargetID = co.TargetID " +
                        "JOIN `CHARACTER` tc ON tc.CharacterID = co.TargetID " +
                        "LEFT JOIN `CHARACTER` hc ON hc.CharacterID = co.BountyHunterID " +
                        "LEFT JOIN PLANET p ON p.PlanetID = t.LastLocationPlanetID " +
                        "ORDER BY t.Value DESC, tc.Name";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            ResultFormatter.printResultSet(rs);

        } catch (SQLException e) {
            ResultFormatter.printError("Eror in bounty board: " + e.getMessage());
        }
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

