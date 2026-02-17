package com.bountyboard.dao;

import com.bountyboard.model.Character;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object for Character entity.
 * Handles all database operations related to characters.
 */
public class CharacterDAO {
    
    /**
     * Creates a new character in the database.
     * @param character The character to create
     * @return The ID of the newly created character
     * @throws SQLException If database operation fails
     */
    public int create(Character character) throws SQLException {
        // TODO: Implement character creation
        return 0;
    }
    
    /**
     * Retrieves a character by ID.
     * @param characterId The ID of the character to retrieve
     * @return The character, or null if not found
     * @throws SQLException If database operation fails
     */
    public Character read(int characterId) throws SQLException {
        // TODO: Implement character retrieval
        return null;
    }
    
    /**
     * Updates an existing character in the database.
     * @param character The character with updated information
     * @return True if update was successful, false otherwise
     * @throws SQLException If database operation fails
     */
    public boolean update(Character character) throws SQLException {
        // TODO: Implement character update
        return false;
    }
    
    /**
     * Deletes a character from the database.
     * @param characterId The ID of the character to delete
     * @return True if deletion was successful, false otherwise
     * @throws SQLException If database operation fails
     */
    public boolean delete(int characterId) throws SQLException {
        // TODO: Implement character deletion
        return false;
    }
    
    /**
     * Retrieves all characters from the database.
     * @return List of all characters
     * @throws SQLException If database operation fails
     */
    public List<Character> listAll() throws SQLException {
        // TODO: Implement list all characters
        return null;
    }
}
