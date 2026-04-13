// Import necessary classes
import java.util.HashMap;

public class java_03823_SessionManager_A01 {
    private String username;
    private String password;

    public java_03823_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
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
}

public class LoginManager {
    private HashMap<String, User> users;

    public java_03823_SessionManager_A01() {
        users = new HashMap<>();
        users.put("admin", new User("admin", "password"));
        users.put("user", new User("user", "password"));
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

public class SessionManager {
    private LoginManager loginManager;
    private User currentUser;

    public java_03823_SessionManager_A01(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public boolean login(String username, String password) {
        if (loginManager.login(username, password)) {
            currentUser = new User(username, password);
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

public class Main {
    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();
        SessionManager sessionManager = new SessionManager(loginManager);

        sessionManager.login("admin", "password");

        if (sessionManager.login("user", "password")) {
            User currentUser = sessionManager.getCurrentUser();
            System.out.println("Logged in as " + currentUser.getUsername());
        }
    }
}