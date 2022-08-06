package view;

import controller.MainMenuController;
import Enum.*;

import java.util.Scanner;

public class MainMenu extends Menu {

    private final MainMenuController mainMenuController;

    public MainMenu(Scanner scanner, MainMenuController mainMenuController) {
        super(scanner);
        this.mainMenuController = mainMenuController;
    }

    @Override
    public void run() {
        while (MenuName.getCurrentMenu() == MenuName.MAIN_MENU) {
            System.out.println(MenuHint.MAIN_MENU.getHint());
            String input;
            input = scanner.nextLine();
            switch (input) {
                case "1": {
                    System.out.println("please enter <name> <username> <password> in order and without spaces!");
                    String register = scanner.nextLine();
                    String result = mainMenuController.register(register);
                    System.out.println(result);
                    break;
                }
                case "2": {
                    System.out.println("please enter <username> <password> in order");
                    String login = scanner.nextLine();
                    String result = mainMenuController.login(login);
                    System.out.println(result);
                    break;
                }
                case "3": {
                    String result = mainMenuController.scoreBoard();
                    System.out.println(result);
                    break;
                }
                case "4": {
                    String result = mainMenuController.exit();
                    System.out.println(result);
                    break;
                }
                default: {
                    System.out.println("invalid input!");
                    break;
                }
            }
        }
    }
}
