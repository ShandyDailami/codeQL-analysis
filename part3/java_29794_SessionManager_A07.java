import java.util.HashMap;
import java.util.Map;

public class java_29794_SessionManager_A07 {
    // Create a map for storing session data
    private Map<String, String> sessionData;

    // Constructor
    public java_29794_SessionManager_A07() {
        sessionData = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a random session key and store it in the session data map
        String sessionKey = generateRandomSessionKey();
        sessionData.put(sessionKey, userId);

        return sessionKey;
    }

    // Method to retrieve the user ID from a session
    public String getUserIdFromSession(String sessionKey) {
        // Retrieve the user ID from the session data map
        return sessionData.get(sessionKey);
    }

    // Method to validate a session
    public boolean validateSession(String sessionKey) {
        // Check if the session key exists in the session data map
        return sessionData.containsKey(sessionKey);
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session key from the session data map
        sessionData.remove(sessionKey);
    }

    // Generate a random session key
    private String generateRandomSessionKey() {
        // Implement your own logic for generating a random session key
        // For example, you could use UUID
        String sessionKey = UUID.randomUUID().toString();
        return sessionKey;
    }
}