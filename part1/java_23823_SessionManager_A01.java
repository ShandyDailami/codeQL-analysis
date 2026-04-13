import java.util.*;

class java_23823_SessionManager_A01 {
    private String name;
    private String password;

    public Main(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

class UserDatabase {
    private Map<String, User> database;

    public Main() {
        database = new HashMap<>();
        database.put("user1", new User("user1", "password1"));
        database.put("user2", new User("user2", "password2"));
    }

    public User getUser(String username) {
        return database.get(username);
    }
}

class SecurityManager {
    private UserDatabase userDatabase;

    public Main() {
        userDatabase = new UserDatabase();
    }

    public User login(String username, String password) {
        User user = userDatabase.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}

public class Main {
    private SecurityManager securityManager;

    public Main() {
        securityManager = new SecurityManager();
    }

    public static void main(String[] args) {
        Main main = new Main();
        User user = main.securityManager.login("user1", "password1");
        if (user != null) {
            System.out.println("Logged in as " + user.getName());
        } else {
            System.out.println("Login failed");
        }
    }
}