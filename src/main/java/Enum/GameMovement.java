package Enum;

public enum GameMovement {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private String movement;

    public String getMovement() {
        return movement;
    }

    GameMovement(String movement) {
        this.movement = movement;
    }
    public static GameMovement getMove(String input) {
        if (input.equals("rock")) return ROCK;
        if (input.equals("paper")) return PAPER;
        if (input.equals("scissors")) return SCISSORS;
        return null;
    }
}
