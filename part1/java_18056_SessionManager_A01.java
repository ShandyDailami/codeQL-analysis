import java.util.*;

public class java_18056_SessionManager_A01 {
    private String username;
    private String password;

    public java_18056_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class SessionManager {
    private HashMap<String, User> users;

    public java_18056_SessionManager_A01() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return this.users.get(username);
    }
}