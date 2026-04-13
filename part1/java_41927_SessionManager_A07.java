import java.util.HashMap;
import java.util.Map;

public class java_41927_SessionManager_A07 {

    // Map to store authenticated users
    private Map<String, Boolean> users;

    public java_41927_SessionManager_A07() {
        this.users = new HashMap<>();
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        // Simulate authentication by checking if user exists and password is correct
        if (this.users.containsKey(username)) {
            return this.users.get(username);
        } else {
            return false;
        }
    }

    // Method to perform an operation if user is authenticated
    public void performOperation(String operation, boolean isAuthenticated) {
        if (isAuthenticated) {
            System.out.println("Performing operation: " + operation);
        } else {
            System.out.println("Unauthenticated user. Can't perform operation.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Authenticate a user
        sessionManager.authenticateUser("user1", true);

        // Try to perform an operation without authentication
        sessionManager.performOperation("Read data", false);

        // Try to perform an operation with authentication
        sessionManager.performOperation("Update data", true);
    }
}