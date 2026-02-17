package com.bountyboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages database connections.
 * Provides a singleton connection instance for the application.
 */
public class DatabaseConnection {
    private static Connection connection = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BountyHunterBoard";
    private static final String DB_USER = "root"; // TODO: Update with actual credentials
    private static final String DB_PASSWORD = ""; // TODO: Update with actual password
    
    /**
     * Gets a database connection instance.
     * Creates a new connection if one doesn't exist.
     * @return The database connection
     * @throws SQLException If connection cannot be established
     */
    public static Connection getConnection() throws SQLException {
        // TODO: Implement connection management
        return null;
    }
    
    /**
     * Closes the database connection.
     */
    public static void closeConnection() {
        // TODO: Implement connection closing
    }
}
