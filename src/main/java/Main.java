import controller.MainMenuController;
import view.MainMenu;
import Enum.MenuName;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        launch();
    }

    private static void launch() {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner , new MainMenuController());
        while (MenuName.getCurrentMenu() != MenuName.TERMINATE) {
            mainMenu.run();
        }
    }
}
