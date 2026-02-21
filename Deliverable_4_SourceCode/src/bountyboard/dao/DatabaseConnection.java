package bountyboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages database connections.
 * Provides a singleton connection instance for the application.
 */
public class DatabaseConnection {
    public static Connection getConnection(String jdbcUrl, String user, String pass) throws SQLException {
        return DriverManager.getConnection(jdbcUrl, user, pass);
    }
}
