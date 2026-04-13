import java.util.HashMap;
import java.util.Map;

public class java_03328_SessionManager_A01 {
    // A map to store user credentials
    private Map<String, String> credentials;

    // Initializing the credentials map
    public java_03328_SessionManager_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    // Method to check if a user is authenticated
    public boolean isAuthenticated(String username) {
        return credentials.containsKey(username);
    }

    // Method to allow access to specific resources
    public void accessResource(String username) {
        if (isAuthenticated(username)) {
            System.out.println("Access granted to user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }

    // Main method to test the session manager
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Attempt to access a resource as an unauthenticated user
        sessionManager.accessResource("user1");

        // Attempt to access a resource as a user authenticated as admin
        sessionManager.accessResource("admin");
    }
}