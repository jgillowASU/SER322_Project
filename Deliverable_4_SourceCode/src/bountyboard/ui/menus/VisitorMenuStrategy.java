package bountyboard.ui.menus;

import bountyboard.dao.BountyBoardService;
import bountyboard.ui.util.InputValidator;

/**
 * Menu strategy for complex queries from Deliverable 3.
 */

public class VisitorMenuStrategy implements MenuStrategy {
    private final BountyBoardService service;

    public VisitorMenuStrategy(BountyBoardService service) {
        this.service = service;
    }

    @Override
    public MenuStrategy execute() {
        while (true) {
            displayMenu();

            int choice = InputValidator.readInt("> ");

            if (choice == 0) {
                return new MainMenuStrategy(service);
            }

            if (choice == 1) {
                service.printBountyBoard();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("=== Visitor Menu ===");
        System.out.println("1) View bounty board");
        System.out.println("0) Back");
    }
}