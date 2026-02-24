package com.bountyboard.ui.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Utility class for formatting query results for display.
 */
public class ResultFormatter {
    
    /**
     * Formats a ResultSet as a table and prints it to console.
     * @param rs The ResultSet to format
     * @throws SQLException If there's an error reading the ResultSet
     */
    public static void printResultSet(ResultSet rs) throws SQLException {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            // header
            for (int i = 1; i <= cols; i++) {
                System.out.print(meta.getColumnLabel(i));
                if (i < cols) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            // Rows
            boolean any = false;
            while (rs.next()) {
                any = true;
                for (int i = 1; i <= cols; i++) {
                    Object value = rs.getObject(i);
                    System.out.print(value == null ? "NULL" : value.toString());
                    if (i < cols) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            if (!any) {
                System.out.println("(none)");
            }
        } catch (SQLException e) {
            printError("Failed to format result set: " + e.getMessage());
        }
    }
    
    /**
     * Formats a message for display.
     * @param message The message to format
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Formats an error message for display.
     * @param error The error message to format
     */
    public static void printError(String error) {
        System.out.println("Error: " + error);
    }
}
