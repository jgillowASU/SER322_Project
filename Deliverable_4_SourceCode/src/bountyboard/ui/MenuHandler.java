package bountyboard.ui;

import bountyboard.dao.BountyBoardService;
import bountyboard.ui.menus.MainMenuStrategy;
import bountyboard.ui.menus.MenuStrategy;

/**
 * Main menu coordinator that manages menu navigation and state.
 */
public class MenuHandler {
    private MenuStrategy currentMenu;

    public MenuHandler(BountyBoardService service) {
        this.currentMenu = new MainMenuStrategy(service);
    }

    public void start() {
        while (currentMenu != null) {
            currentMenu = currentMenu.execute();
        }
    }

    public void navigateTo(MenuStrategy menu) {
        currentMenu = menu;
    }

    public void returnToMainMenu(BountyBoardService service) {
        currentMenu = new MainMenuStrategy(service);
    }
}