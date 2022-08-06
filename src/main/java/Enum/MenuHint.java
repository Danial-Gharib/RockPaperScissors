package Enum;

public enum MenuHint {
    MAIN_MENU("""
            put 1 for sign-up
            2 for login
            3 for scoreboard
            and 4 for exit!"""),
    USER_PANEL("""
            type 'stats' for showing show statistics
            'logout' for logging out
            and 'play' for playing a new game!"""),
    GAME("""
            type 'rock' for rock
            'paper' for paper
            and 'scissors' for scissors!""");

    private final String hint;

    MenuHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
