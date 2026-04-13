import java.util.HashMap;
import java.util.Map;

public class java_17531_SessionManager_A08 {
    // A map to simulate a session storage
    private Map<String, String> sessionMap;

    // The constructor initializes the session map
    public java_17531_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Create a session key from user id
        String sessionKey = userId + System.currentTimeMillis();

        // Add the session key and user id to the session map
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Verify if the session key exists in the session map
        if (sessionMap.containsKey(sessionKey)) {
            // If the session key exists, return the corresponding user id
            return sessionMap.get(sessionKey);
        } else {
            // If the session key does not exist, return null
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session key from the session map
        sessionMap.remove(sessionKey);
    }
}