package view;

import controller.GameController;
import Enum.*;
import java.util.Scanner;

public class GameView extends Menu{
    private final GameController gameController;
    public GameView(Scanner scanner, GameController gameController) {
        super(scanner);
        this.gameController = gameController;
    }

    @Override
    public void run() {
        System.out.println(MenuHint.GAME.getHint());
        while (MenuName.getCurrentMenu() == MenuName.GAME && gameController.isRunning()) {
            String input;
            input = scanner.nextLine();
            GameMovement gameMovement = GameMovement.getMove(input);
            String result = gameController.move(gameMovement);
            System.out.println(result);
        }
        if (gameController.isHasWon()) System.out.println("congratulations! you won!!");
        else System.out.println("sorry!! maybe next time!");
    }
}
