package Enum;

public enum MenuName {
    MAIN_MENU,
    TERMINATE;

    private static MenuName currentMenu = MAIN_MENU; //for starting the program

    public static MenuName getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(MenuName menuName) {
        MenuName.currentMenu = menuName;
    }
}
