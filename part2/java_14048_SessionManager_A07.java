import java.util.HashMap;
import java.util.Map;

public class java_14048_SessionManager_A07 {
    // Mock users and their passwords
    private static Map<String, String> users = new HashMap<>();
    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    // Login method
    public boolean login(String username, String password) {
        if (!users.containsKey(username) || !users.get(username).equals(password)) {
            return false;
        }
        return true;
    }

    // Check if user is authenticated
    public boolean isAuthenticated(String username) {
        return users.containsKey(username);
    }

    // Get authenticated user
    public String getAuthenticatedUser(String username) {
        return users.get(username);
    }

    // Main method to test
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Authenticate as user1
        boolean authenticated = manager.login("user1", "password1");
        if (authenticated) {
            System.out.println("User " + manager.getAuthenticatedUser("user1") + " is authenticated.");
        } else {
            System.out.println("Authentication failed.");
        }

        // Attempt to authenticate as user3
        authenticated = manager.login("user3", "password3");
        if (authenticated) {
            System.out.println("User " + manager.getAuthenticatedUser("user3") + " is authenticated.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}