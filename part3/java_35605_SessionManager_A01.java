import java.util.HashMap;
import java.util.Map;

public class java_35605_SessionManager_A01 {

    // Map to store session data
    private Map<String, String> sessionData;

    // Constructor
    public java_35605_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a session key
        String sessionKey = generateSessionKey();

        // Store the session key and username in the session data map
        sessionData.put(sessionKey, username);

        return sessionKey;
    }

    // Method to retrieve a username from a session
    public String getUsername(String sessionKey) {
        // Check if the session key exists in the session data map
        if (sessionData.containsKey(sessionKey)) {
            return sessionData.get(sessionKey);
        } else {
            throw new RuntimeException("Invalid session key");
        }
    }

    // Method to validate a session
    public boolean validateSession(String sessionKey, String expectedUsername) {
        // Check if the session key exists in the session data map
        if (sessionData.containsKey(sessionKey)) {
            // Check if the expected username matches the actual username
            if (sessionData.get(sessionKey).equals(expectedUsername)) {
                return true;
            } else {
                throw new RuntimeException("Invalid session");
            }
        } else {
            throw new RuntimeException("Invalid session key");
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionKey) {
        // Check if the session key exists in the session data map
        if (sessionData.containsKey(sessionKey)) {
            // Remove the session key and username from the session data map
            sessionData.remove(sessionKey);
        } else {
            throw new RuntimeException("Invalid session key");
        }
    }

    // Generate a session key (This is a placeholder method, you would need to implement your own session key generation logic)
    private String generateSessionKey() {
        // Here, you would generate a session key using your own logic
        // This could be a UUID, a random string, etc.
        return "sessionKey";
    }
}