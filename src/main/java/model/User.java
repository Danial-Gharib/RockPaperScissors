package model;

public class User implements Comparable<User>{
    private String name;
    private String username;
    private String password;
    private int noOfWins;
    private int noOfLosses;
    private float winRate;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.noOfWins = 0;
        this.noOfLosses = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfLosses() {
        return noOfLosses;
    }

    public void setNoOfLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }

    public float getWinRate() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        this.winRate = winRate;
    }

    @Override
    public int compareTo(User o) {
        return o.getNoOfWins() - this.getNoOfWins();
    }
}
