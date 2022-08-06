package view;

import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner;
    public abstract void run();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }
}
