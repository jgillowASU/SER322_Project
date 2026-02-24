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
        while (true) {
            System.out.print(prompt);

            if (!scanner.hasNextLine()) {
                System.out.println();
                System.out.println("No input available. Exiting.");
                System.exit(0);
            }

            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    /**
     * Prompts user and reads a string input.
     * @param prompt The prompt message to display
     * @return The string value entered by the user
     */
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!scanner.hasNextLine()) {
                System.out.println();
                System.out.println("No input present. Exiting.");
                System.exit(0);
            }

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
    
    /**
     * Validates that an integer is within a specified range.
     * @param value The value to validate
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return True if value is within range, false otherwise
     */
    public static boolean isValidRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
