import java.util.HashMap;
import java.util.Map;

public class java_18896_SessionManager_A07 {
    // A simple in-memory store for user credentials
    private Map<String, String> userCredentials = new HashMap<>();

    public java_18896_SessionManager_A07() {
        // Add some dummy users for testing
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        // Check if the credentials are correct
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            // Generate a session ID
            return generateSessionID(username);
        } else {
            // If the credentials are incorrect, return an empty string
            return "";
        }
    }

    // A very simple session ID generation. In a real-world scenario, you would probably use
    // a more complex method to ensure session IDs are securely generated and unique.
    private String generateSessionID(String username) {
        return username;  // This is a naive example and should not be used for real-world applications
    }
}