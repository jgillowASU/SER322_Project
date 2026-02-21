package bountyboard.ui.menus;

import bountyboard.dao.BountyBoardService;
import bountyboard.ui.util.InputValidator;

/**
 * Main menu strategy - displays the top-level menu options.
 */
public class MainMenuStrategy implements MenuStrategy {
    private final BountyBoardService service;

    public MainMenuStrategy(BountyBoardService service) {
        this.service = service;
    }

    @Override
    public MenuStrategy execute() {
        displayMenu();
        int choice = InputValidator.readInt("> ");

        if (choice == 0) {
            return null;
        } else if (choice == 1) {
            return new SyndicateMenuStrategy(service);
        } else if (choice == 2) {
            return new BountyHunterMenuStrategy(service);
        } else if (choice == 3) {
            return new VisitorMenuStrategy(service);
        }

        System.out.println("Invalid choice.");

        return this;
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("*** Star Wars Bounty Board ***");
        System.out.println("Choose role:");
        System.out.println("1) Syndicate");
        System.out.println("2) Bounty Hunter");
        System.out.println("3) Visitor");
        System.out.println("0) Exit");
    }
}