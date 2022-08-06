import controller.MainMenuController;
import controller.UserController;
import controller.UserPanelController;
import view.MainMenu;
import Enum.MenuName;
import view.UserPanel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        UserController.getInstance().loadUsers();
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner, new MainMenuController());
        UserPanel userPanel = new UserPanel(scanner, new UserPanelController());
        while (MenuName.getCurrentMenu() != MenuName.TERMINATE) {
            mainMenu.run();
            userPanel.run();
        }
    }
}
