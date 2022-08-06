package controller;

import Enum.MenuName;
import model.User;

import java.util.ArrayList;

public class MainMenuController {

    public String exit() {
        MenuName.setCurrentMenu(MenuName.TERMINATE);
        UserController.getInstance().saveUsers();
        return "program terminated!";
    }

    public String register(String register) {
        String[] inputs = register.split(" ");
        if (inputs.length != 3) return "invalid inputs!";
        User user = new User(inputs[0], inputs[1], inputs[2]);
        UserController userController = UserController.getInstance();
        if (userController.hasThisUser(inputs[1])) return "a user with this username already exists!";
        userController.addUser(user);
        MenuName.setCurrentMenu(MenuName.USER_PANEL);
        userController.setCurrentUser(user);
        return "sign-up successful!";
    }

    public String login(String login) {
        String[] inputs = login.split(" ");
        if (inputs.length != 2) return "invalid inputs!";
        User user = UserController.getInstance().getUserByUsername(inputs[0]);
        if (user == null) return "no such user was found!";
        if (!user.getPassword().equals(inputs[1])) return "username and password didn't match!";
        UserController.getInstance().setCurrentUser(user);
        MenuName.setCurrentMenu(MenuName.USER_PANEL);
        return "login successful!";
    }

    public String scoreBoard() {
        ArrayList<User> users = UserController.getInstance().getUsers();
        if (users.size() == 0) return "no users yet!";
        users.sort(User::compareTo);
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append("name : " + user.getName() + " | number of wins : " + user.getNoOfWins() + "\n");
        }
        return stringBuilder.toString();
    }
}
