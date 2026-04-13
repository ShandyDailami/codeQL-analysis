import java.util.HashMap;
import java.util.Map;

public class java_03046_SessionManager_A07 {
    // Create a session map
    private Map<String, String> sessionMap;

    // Constructor
    public java_03046_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session key
        String sessionKey = String.valueOf(System.currentTimeMillis());

        // Add the session key and user id to the session map
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to validate a session
    public String validateSession(String sessionKey) {
        // Remove the session key from the session map
        String userId = sessionMap.remove(sessionKey);

        // Return the user id from the session map
        return userId;
    }
}