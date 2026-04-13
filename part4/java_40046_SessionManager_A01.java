import java.util.HashMap;
import java.util.Map;

public class java_40046_SessionManager_A01 {
    // Define a map to store credentials
    private Map<String, String> credentials = new HashMap<>();

    // Constructor
    public java_40046_SessionManager_A01() {
        // Add some default credentials
        credentials.put("admin", "password");
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        // Check if the provided username and password match the stored credentials
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if a user has access to a specific operation
    public boolean hasAccess(String username, String operation) {
        // For simplicity, let's assume that all operations require authentication
        // In a real application, you would need a more sophisticated system to check access
        if (authenticate(username, operation)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        // Test authenticate
        System.out.println(manager.authenticate("admin", "password")); // true
        System.out.println(manager.authenticate("admin", "wrongPassword")); // false

        // Test hasAccess
        System.out.println(manager.hasAccess("admin", "read")); // true
        System.out.println(manager.hasAccess("admin", "write")); // false
    }
}