import java.util.HashMap;
import java.util.Map;

public class java_14355_SessionManager_A01 {
    // Simulate a map where the key is the username and the value is the password
    private Map<String, String> credentials;

    // Constructor
    public java_14355_SessionManager_A01() {
        this.credentials = new HashMap<>();
    }

    // Method to add a new user
    public void addUser(String username, String password) {
        this.credentials.put(username, password);
    }

    // Method to login with a username and password
    public boolean login(String username, String password) {
        // Check if the provided password matches the stored password
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            // If the password matches, return true
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new SessionManager
        SessionManager sessionManager = new SessionManager();

        // Add a new user
        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        // Login as user1
        boolean isLoggedIn = sessionManager.login("user1", "password1");
        if (isLoggedIn) {
            System.out.println("User1 is logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }

        // Attempt to login as user2 with the incorrect password
        isLoggedIn = sessionManager.login("user2", "wrongpassword");
        if (isLoggedIn) {
            System.out.println("User2 is logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }
    }
}