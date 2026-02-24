package com.bountyboard.ui.menus;

import com.bountyboard.dao.BountyBoardService;
import com.bountyboard.ui.util.InputValidator;

/**
 * Menu strategy for BountyHunter entity CRUD operations.
 */
public class BountyHunterMenuStrategy implements MenuStrategy {
    private final BountyBoardService service;

    public BountyHunterMenuStrategy(BountyBoardService service) {
        this.service = service;
    }

    @Override
    public MenuStrategy execute() {
        System.out.println();
        System.out.println("Available Bounty Hunters | ID | Name | Credits |");

        service.printBountyHunters();

        int hunterId = InputValidator.readInt("Enter BountyHunterID (0 to cancel): ");

        if (hunterId == 0) {
            return new MainMenuStrategy(service);
        }

        if (!service.hunterExists(hunterId)) {
            System.out.println("No such bounty hunter.");
            return new MainMenuStrategy(service);
        }

        while (true) {
            displayMenu();

            int choice = InputValidator.readInt("> ");

            if (choice == 0) {
                return new MainMenuStrategy(service);
            }

            if (choice == 1) {
                service.printBountyBoard();
            } else if (choice == 2) {
                System.out.println();

                service.printUnassignedBounties();

                int contractId = InputValidator.readInt("Enter ContractID to claim (0 to cancel): ");

                if (contractId != 0) {
                    service.claimBounty(contractId, hunterId);
                }
            } else if (choice == 3) {

                System.out.println();
                service.printBountiesAssignedToHunter(hunterId);

                int contractId = InputValidator.readInt("Enter ContractID to complete (0 to cancel): ");

                if (contractId != 0) {
                    service.setCompleted(contractId, hunterId);
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.println("=== Bounty Hunter Menu ===");
        System.out.println("1) View bounty board");
        System.out.println("2) Take on bounty");
        System.out.println("3) Mark bounty complete");
        System.out.println("0) Back");
    }
}
