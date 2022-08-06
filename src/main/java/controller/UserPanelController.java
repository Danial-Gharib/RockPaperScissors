package controller;

import Enum.*;
import model.User;
import view.GameView;

import java.util.Scanner;

public class UserPanelController {
    public String getStats() {
        User user = UserController.getInstance().getCurrentUser();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("number of wins : " + user.getNoOfWins() + "\n");
        stringBuilder.append("number of losses : " + user.getNoOfLosses() + "\n");
        if (user.getNoOfLosses() + user.getNoOfWins() == 0) {
            stringBuilder.append("win rate : N/A (have not played yet!)");
        } else {
            float wins = user.getNoOfWins();
            float total = user.getNoOfWins() + user.getNoOfLosses();
            stringBuilder.append("win rate : " + (wins / total) * 100 + "%");
        }
        return stringBuilder.toString();
    }

    public String logout() {
        UserController.getInstance().setCurrentUser(null);
        MenuName.setCurrentMenu(MenuName.MAIN_MENU);
        return "logged out to main menu!";
    }

    public String play(int rounds) {
        GameView gameView = new GameView(new Scanner(System.in), new GameController(rounds));
        MenuName.setCurrentMenu(MenuName.GAME);
        gameView.run();
        return "game started with " + rounds + " rounds!";
    }

}
