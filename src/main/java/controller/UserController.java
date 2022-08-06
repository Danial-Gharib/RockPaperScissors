package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public void loadUsers() {
        try {
            ArrayList<User> loadUsers = new ArrayList<>();
            String json = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/database/database.json").toURI())));
            loadUsers = new Gson().fromJson(json , new TypeToken<List<User>>(){}.getType());
            if (loadUsers != null) users = loadUsers;
        }
        catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }
    public void saveUsers()  {
        try {
            FileWriter fileWriter = new FileWriter("./src/main/resources/database/database.json");
            fileWriter.write(new Gson().toJson(users));
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
