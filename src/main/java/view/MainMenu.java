package view;

import controller.MainMenuController;
import Enum.*;
import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu extends Menu{

    private final MainMenuController mainMenuController;
    public MainMenu(Scanner scanner , MainMenuController mainMenuController) {
        super(scanner);
        this.mainMenuController = mainMenuController;
    }

    @Override
    public void run() {
        while (MenuName.getCurrentMenu() == MenuName.MAIN_MENU) {
            String input;
            Matcher matcher;
            input = scanner.nextLine();

        }
    }
}
