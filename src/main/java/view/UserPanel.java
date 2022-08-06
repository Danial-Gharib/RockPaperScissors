package view;

import controller.UserPanelController;
import Enum.*;
import java.util.Scanner;

public class UserPanel extends Menu {
    private final UserPanelController userPanelController;
    public UserPanel(Scanner scanner, UserPanelController userPanelController) {
        super(scanner);
        this.userPanelController = userPanelController;
    }

    @Override
    public void run() {
        while (MenuName.getCurrentMenu() == MenuName.USER_PANEL) {
            System.out.println(MenuHint.USER_PANEL.getHint());
            String input;
            input = scanner.nextLine();
            switch (input) {
                case "stats" -> {
                    String result = userPanelController.getStats();
                    System.out.println(result);
                }
                case "logout" -> {
                    String result = userPanelController.logout();
                    System.out.println(result);
                }
                case "play" -> {
                    System.out.println("enter limit of score for your play : (a number bigger than 0) ");
                    String result = userPanelController.play(Integer.parseInt(scanner.nextLine()));
                }
                default -> System.out.println("invalid command!");
            }
        }
    }
}
