package com.bountyboard.ui.util;

import java.util.Scanner;

/**
 * Utility class for validating and parsing user input.
 */
public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Prompts user and reads an integer input.
     * @param prompt The prompt message to display
     * @return The integer value entered by the user
     */
    public static int readInt(String prompt) {
        // TODO: Implement integer input validation
        return 0;
    }
    
    /**
     * Prompts user and reads a string input.
     * @param prompt The prompt message to display
     * @return The string value entered by the user
     */
    public static String readString(String prompt) {
        // TODO: Implement string input validation
        return null;
    }
    
    /**
     * Validates that an integer is within a specified range.
     * @param value The value to validate
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return True if value is within range, false otherwise
     */
    public static boolean isValidRange(int value, int min, int max) {
        // TODO: Implement range validation
        return false;
    }
}
