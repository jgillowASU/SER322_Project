package com.bountyboard.ui.menus;

/**
 * Interface for menu strategies.
 * Each menu state implements this interface to handle its own display and user input.
 */
public interface MenuStrategy {
    /**
     * Displays the menu and handles user interaction.
     * Returns the next menu strategy to navigate to, or null to exit.
     */
    MenuStrategy execute();
    
    /**
     * Displays the menu options to the user.
     */
    void displayMenu();
}
