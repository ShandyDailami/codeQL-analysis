import java.util.HashMap;
import java.util.Map;

public class java_29071_SessionManager_A07 {
    // Storing user data in a map
    private Map<String, String> userData = new HashMap<>();

    // Add user data
    public void addUserData(String username, String password) {
        userData.put(username, password);
    }

    // Authenticate user
    public boolean authenticateUser(String username, String password) {
        return userData.get(username).equals(password);
    }

    // Secure method to access a resource
    public void secureMethod(String username, String password) {
        if (authenticateUser(username, password)) {
            // Method implementation
            System.out.println("Accessing resource securely!");
        } else {
            throw new IllegalArgumentException("Invalid credentials!");
        }
    }
}