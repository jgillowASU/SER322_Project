package bountyboard.ui.menus;

import bountyboard.dao.BountyBoardService;
import bountyboard.ui.util.InputValidator;

/**
 * Menu strategy for Syndicate entity CRUD operations.
 */
public class SyndicateMenuStrategy implements MenuStrategy {
    private final BountyBoardService service;

    public SyndicateMenuStrategy(BountyBoardService service) {
        this.service = service;
    }

    @Override
    public MenuStrategy execute() {
        // print out a list of syndicates in the database to select from
        System.out.println();
        service.printSyndicates();
        System.out.println();

        int syndicateId = InputValidator.readInt("Enter SyndicateID (0 to cancel): ");

        if (syndicateId == 0) {
            return new MainMenuStrategy(service);
        }

        if (!service.syndicateExists(syndicateId)) {
            System.out.println("No such syndicate.");
            return new MainMenuStrategy(service);
        }

        while (true) {
            System.out.println();
            service.welcomeSyndicate(syndicateId);
            displayMenu();
            int choice = InputValidator.readInt("> ");

            if (choice == 0) {
                return new MainMenuStrategy(service);
            }

            if (choice == 1) {
                service.printBountyBoard();
            } else if (choice == 2) {
                System.out.println();
                service.printTargets();
                System.out.println();

                int targetId = InputValidator.readInt("Enter TargetID (0 to cancel): ");

                if (targetId != 0) {
                    if (service.targetExists(targetId)) {
                        service.createBounty(syndicateId, targetId);
                    } else {
                        System.out.println("No such target.");
                    }
                }
            } else if (choice == 3) {
                service.printUnfinishedBounties();
                System.out.println();
                
                int contractId = InputValidator.readInt("Enter ContractID to delete (0 to cancel): ");

                if (contractId != 0) {
                    service.deleteBountyIfNotCompleted(contractId);
                }

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("=== Syndicate Menu ===");
        System.out.println("1) View bounty board");
        System.out.println("2) Create bounty against known target");
        System.out.println("3) Delete an incomplete bounty");
        System.out.println("0) Back");
    }
}