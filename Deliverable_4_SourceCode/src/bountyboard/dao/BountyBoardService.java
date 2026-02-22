package bountyboard.dao;

import java.sql.*;

public class BountyBoardService {
    private final Connection connection;

    public BountyBoardService(Connection connection) {
        this.connection = connection;
    }

    // For lists to select from---

    public void printSyndicates() {
        String sql =
        "SELECT `Name`, SyndicateID " +
        "FROM SYNDICATE";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("Available Syndicates:");
            System.out.printf("%-20s %-15s%n", "Name", "Syndicate ID");
            while (rs.next()) {
                System.out.printf(
                    "%-20s %-15d%n",
                    rs.getString("Name"),
                    rs.getInt("SyndicateID")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing syndicates: " + e.getMessage());
        }
    }

    public void welcomeSyndicate(int syndicateId) {
        String sql =
            "SELECT `Name` " +
            "FROM SYNDICATE " +
            "WHERE SyndicateID = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, syndicateId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String syndicateName = rs.getString("Name");
                    System.out.println("Welcome, " + syndicateName + ".");
                } else {
                    System.out.println("No syndicate found for ID: " + syndicateId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error looking up syndicate name: " + e.getMessage());
        }
    }

    public void printTargets() {
        String sql =
        "SELECT c.Name, t.TargetID, t.Value, p.Name AS LastKnownPlanet " +
        "FROM TARGET t " +
        "JOIN `CHARACTER` c ON t.TargetID = c.CharacterID " +
        "LEFT JOIN PLANET p ON t.LastLocationPlanetID = p.PlanetID";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("Available Targets:");
            System.out.printf("%-20s %-12s %-10s %-20s%n", "Name", "Target ID", "Value", "Last Known Planet");
            while (rs.next()) {
                String lastKnownPlanet = rs.getString("LastKnownPlanet");
                if (lastKnownPlanet == null) {
                    lastKnownPlanet = "Unknown";
                }

                System.out.printf(
                    "%-20s %-12d %-10d %-20s%n",
                    rs.getString("Name"),
                    rs.getInt("TargetID"),
                    rs.getInt("Value"),
                    lastKnownPlanet
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing targets: " + e.getMessage());
        }
    }

    public void printHunters() {
        String sql =
        "SELECT c.Name, bh.BountyHunterID, bh.Credits " +
        "FROM BOUNTY_HUNTER bh " +
        "JOIN `CHARACTER` c ON bh.BountyHunterID = c.CharacterID";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            System.out.println("Available Bounty Hunters:");
            System.out.printf("%-20s %-15s %-10s%n", "Name", "Hunter ID", "Credits");
            while (rs.next()) {
                System.out.printf(
                    "%-20s %-15d %-10d%n",
                    rs.getString("Name"),
                    rs.getInt("BountyHunterID"),
                    rs.getInt("Credits")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing hunters: " + e.getMessage());
        }
    }

    public void welcomeHunter(int hunterId) {
        String sql =
            "SELECT c.Name " +
            "FROM BOUNTY_HUNTER bh " +
            "JOIN `CHARACTER` c ON bh.BountyHunterID = c.CharacterID " +
            "WHERE bh.BountyHunterID = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, hunterId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hunterName = rs.getString("Name");
                    System.out.println("Welcome, " + hunterName + ".");
                } else {
                    System.out.println("No bounty hunter found for ID: " + hunterId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error looking up hunter name: " + e.getMessage());
        }
    }

    // ---------

    // --- For everyone ----

    public void printBountyBoard() {
        String sql =
        "SELECT con.ContractID, c.Name AS TargetName, con.SyndicateID, con.TargetID, t.Value AS TargetValue, con.BountyHunterID, con.CompletionStatus " +
        "FROM CONTRACT con " +
        "JOIN TARGET t ON con.TargetID = t.TargetID " +
        "JOIN `CHARACTER` c ON t.TargetID = c.CharacterID";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            System.out.println();
            System.out.println("Bounty Board:");
            System.out.printf(
                "%-12s %-20s %-14s %-10s %-14s %-15s %-18s%n",
                "Contract ID",
                "Target Name",
                "Syndicate ID",
                "Target ID",
                "Target Value",
                "Hunter ID",
                "Completion Status"
            );

            while (rs.next()) {
                int hunterId = rs.getInt("BountyHunterID");
                String hunterDisplay = rs.wasNull() ? "Unassigned" : String.valueOf(hunterId);

                System.out.printf(
                    "%-12d %-20s %-14d %-10d %-14d %-15s %-18s%n",
                    rs.getInt("ContractID"),
                    rs.getString("TargetName"),
                    rs.getInt("SyndicateID"),
                    rs.getInt("TargetID"),
                    rs.getInt("TargetValue"),
                    hunterDisplay,
                    rs.getString("CompletionStatus")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing bounty board: " + e.getMessage());
        }
    }

    public void printUnassignedBounties() {
        String sql =
        "SELECT con.ContractID, c.Name AS TargetName, con.SyndicateID, con.TargetID, t.Value AS TargetValue, con.BountyHunterID, con.CompletionStatus " +
        "FROM CONTRACT con " +
        "JOIN TARGET t ON con.TargetID = t.TargetID " +
        "JOIN `CHARACTER` c ON t.TargetID = c.CharacterID " +
        "WHERE con.BountyHunterID IS NULL";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("Unassigned Bounties:");
            System.out.printf(
                "%-12s %-20s %-14s %-10s %-14s %-15s %-18s%n",
                "Contract ID",
                "Target Name",
                "Syndicate ID",
                "Target ID",
                "Target Value",
                "Hunter ID",
                "Completion Status"
            );

            while (rs.next()) {
                int hunterId = rs.getInt("BountyHunterID");
                String hunterDisplay = rs.wasNull() ? "Unassigned" : String.valueOf(hunterId);

                System.out.printf(
                    "%-12d %-20s %-14d %-10d %-14d %-15s %-18s%n",
                    rs.getInt("ContractID"),
                    rs.getString("TargetName"),
                    rs.getInt("SyndicateID"),
                    rs.getInt("TargetID"),
                    rs.getInt("TargetValue"),
                    hunterDisplay,
                    rs.getString("CompletionStatus")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing unassigned bounties: " + e.getMessage());
        }
    }

    public void printUnfinishedBounties() {
        String sql =
        "SELECT con.ContractID, c.Name AS TargetName, con.SyndicateID, con.TargetID, t.Value AS TargetValue, con.BountyHunterID, con.CompletionStatus " +
        "FROM CONTRACT con " +
        "JOIN TARGET t ON con.TargetID = t.TargetID " +
        "JOIN `CHARACTER` c ON t.TargetID = c.CharacterID " +
        "WHERE con.CompletionStatus = 'Pending'";

        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            System.out.println();
            System.out.println("Unfinished Bounties:");
            System.out.printf(
                "%-12s %-20s %-14s %-10s %-14s %-15s %-18s%n",
                "Contract ID",
                "Target Name",
                "Syndicate ID",
                "Target ID",
                "Target Value",
                "Hunter ID",
                "Completion Status"
            );

            while (rs.next()) {
                int hunterId = rs.getInt("BountyHunterID");
                String hunterDisplay = rs.wasNull() ? "Unassigned" : String.valueOf(hunterId);

                System.out.printf(
                    "%-12d %-20s %-14d %-10d %-14d %-15s %-18s%n",
                    rs.getInt("ContractID"),
                    rs.getString("TargetName"),
                    rs.getInt("SyndicateID"),
                    rs.getInt("TargetID"),
                    rs.getInt("TargetValue"),
                    hunterDisplay,
                    rs.getString("CompletionStatus")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error printing unfinished bounties: " + e.getMessage());
        }
    }

    public void printBountiesAssignedToHunter(int hunterId) {
        String sql =
        "SELECT con.ContractID, c.Name AS TargetName, con.SyndicateID, con.TargetID, t.Value AS TargetValue, con.BountyHunterID, con.CompletionStatus " +
        "FROM CONTRACT con " +
        "JOIN TARGET t ON con.TargetID = t.TargetID " +
        "JOIN `CHARACTER` c ON t.TargetID = c.CharacterID " +
        "WHERE con.BountyHunterID = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, hunterId);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println();
                System.out.println("Bounties Assigned to Hunter ID " + hunterId + ":");
                System.out.printf(
                    "%-12s %-20s %-14s %-10s %-14s %-15s %-18s%n",
                    "Contract ID",
                    "Target Name",
                    "Syndicate ID",
                    "Target ID",
                    "Target Value",
                    "Hunter ID",
                    "Completion Status"
                );

                while (rs.next()) {
                    System.out.printf(
                        "%-12d %-20s %-14d %-10d %-14d %-15d %-18s%n",
                        rs.getInt("ContractID"),
                        rs.getString("TargetName"),
                        rs.getInt("SyndicateID"),
                        rs.getInt("TargetID"),
                        rs.getInt("TargetValue"),
                        rs.getInt("BountyHunterID"),
                        rs.getString("CompletionStatus")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error printing bounties assigned to hunter: " + e.getMessage());
        }
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

