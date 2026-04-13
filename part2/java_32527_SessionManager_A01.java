import java.util.HashMap;
import java.util.Map;

public class java_32527_SessionManager_A01 {
    private Map<String, String> database;

    public java_32527_SessionManager_A01() {
        // Initialize the database with sample users.
        database = new HashMap<>();
        database.put("user1", "password1");
        database.put("user2", "password2");
    }

    public String getPassword(String username) {
        return database.get(username);
    }

    public boolean validateUser(String username, String password) {
        String dbPassword = database.get(username);
        return dbPassword != null && dbPassword.equals(password);
    }
}

public class BrokenAccessControlExample {
    public static void main(String[] args) {
        // Setup the session manager.
        SessionManager sessionManager = new SessionManager();

        // Attempt to login with invalid credentials.
        if (sessionManager.validateUser("invalidUser", "invalidPassword")) {
            System.out.println("Access denied: Invalid credentials");
        } else {
            System.out.println("Access granted: Welcome, invalidUser!");
        }
    }
}