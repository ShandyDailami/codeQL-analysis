import java.util.HashMap;
import java.util.Map;

public class java_18253_SessionManager_A01 {
    // A map to store session data
    private Map<String, String> sessionMap;

    // Initialize sessionMap in the constructor
    public java_18253_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session key
        String sessionKey = userId + System.currentTimeMillis();

        // Store the userId in the sessionMap
        sessionMap.put(sessionKey, userId);

        // Return the session key
        return sessionKey;
    }

    // Method to get the userId for a session
    public String getUserId(String sessionKey) {
        // Return the userId from the sessionMap
        return sessionMap.get(sessionKey);
    }

    // Method to destroy a session
    public void destroySession(String sessionKey) {
        // Remove the session from the sessionMap
        sessionMap.remove(sessionKey);
    }
}