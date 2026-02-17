package com.bountyboard.dao;

import com.bountyboard.model.BountyHunter;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object for BountyHunter entity.
 * Handles all database operations related to bounty hunters.
 */
public class BountyHunterDAO {
    
    public int create(BountyHunter bountyHunter) throws SQLException {
        // TODO: Implement bounty hunter creation
        return 0;
    }
    
    public BountyHunter read(int bountyHunterId) throws SQLException {
        // TODO: Implement bounty hunter retrieval
        return null;
    }
    
    public boolean update(BountyHunter bountyHunter) throws SQLException {
        // TODO: Implement bounty hunter update
        return false;
    }
    
    public boolean delete(int bountyHunterId) throws SQLException {
        // TODO: Implement bounty hunter deletion
        return false;
    }
    
    public List<BountyHunter> listAll() throws SQLException {
        // TODO: Implement list all bounty hunters
        return null;
    }
}
