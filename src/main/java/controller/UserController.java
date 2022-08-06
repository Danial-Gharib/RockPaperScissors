package controller;

import model.User;

import java.util.ArrayList;

public class UserController {
    private User currentUser;


    public static UserController instance;
    public static UserController getInstance() {
        if (instance == null) instance = new UserController();
        return instance;
    }
    private UserController() {
        this.users = new ArrayList<>();
    }
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean hasThisUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return true;
        }
        return false;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
