package controller;

import Enum.*;
import model.User;

import java.util.Random;

public class GameController {
    private int rounds;
    private int userPoints;
    private int computerPoints;
    private boolean hasWon;


    public GameController(int rounds) {
        this.rounds = rounds;
        this.userPoints = 0;
        this.computerPoints = 0;
        this.hasWon = false;
    }

    public boolean isRunning() {
        return userPoints < rounds && computerPoints < rounds;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public void setComputerPoints(int computerPoints) {
        this.computerPoints = computerPoints;
    }

    public String move(GameMovement gameMovement) {
        if (gameMovement == null) return "please enter a valid move!";
        GameMovement computersMove = createRandomMove();
        if (gameMovement == computersMove)
            return gameMovement.getMovement() + " vs " + computersMove.getMovement() + " : draw!";
        if ((gameMovement == GameMovement.ROCK && computersMove == GameMovement.PAPER) ||
                (gameMovement == GameMovement.SCISSORS && computersMove == GameMovement.ROCK) ||
                (gameMovement == GameMovement.PAPER && computersMove == GameMovement.SCISSORS)) {
            this.computerPoints = this.computerPoints + 1;
            isFinished();
            return gameMovement.getMovement() + " vs " + computersMove.getMovement() + " : lost!";
        } else {
            this.userPoints = this.userPoints + 1;
            isFinished();
            return gameMovement.getMovement() + " vs " + computersMove.getMovement() + " : won!";
        }
    }

    private void isFinished() {
        User user = UserController.getInstance().getCurrentUser();
        if (userPoints == rounds) {
            user.setNoOfWins(user.getNoOfWins() + 1);
            MenuName.setCurrentMenu(MenuName.USER_PANEL);
            hasWon = true;
        } else if (computerPoints == rounds) {
            user.setNoOfLosses(user.getNoOfLosses() + 1);
            MenuName.setCurrentMenu(MenuName.USER_PANEL);
        }
    }

    private GameMovement createRandomMove() {
        Random random = new Random();
        int number = 0;
        while (number <= 0) {
            number = random.nextInt();
        }
        return switch (number % 3) {
            case 0 -> GameMovement.ROCK;
            case 1 -> GameMovement.PAPER;
            case 2 -> GameMovement.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + number % 3);
        };
    }
}
