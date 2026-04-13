import java.util.HashMap;
import java.util.Map;

public class java_32267_SessionManager_A07 {

    // Create a Map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_32267_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session key
        String sessionKey = String.valueOf(userId.hashCode());
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to get userId from a session
    public String getUserId(String sessionKey) {
        // Retrieve the userId from the session key
        return sessionMap.get(sessionKey);
    }

    // Method to validate the session
    public boolean isValidSession(String sessionKey) {
        // Check if the session key exists in the session map
        return sessionMap.containsKey(sessionKey);
    }
}