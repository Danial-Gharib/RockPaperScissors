package Enum;

public enum MenuHint {
    MAIN_MENU("put 1 for sign-up\n" +
            "2 for login\n" +
            "3 for scoreboard\n" +
            "and 4 for exit!");

    private final String hint;

    MenuHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
