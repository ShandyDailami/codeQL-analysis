import java.util.HashMap;
import java.util.Map;

public class java_41415_SessionManager_A07 {
    // Using HashMap as the underlying data structure for this session manager
    private Map<String, String> sessionMap;

    public java_41415_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userId) {
        // Generate a unique session key
        String sessionKey = generateSessionKey(userId);
        sessionMap.put(sessionKey, userId);
        return sessionKey;
    }

    // Method to end a session
    public void endSession(String sessionKey) {
        // Remove the session from the map
        sessionMap.remove(sessionKey);
    }

    // Method to get the user id associated with the session
    public String getUserId(String sessionKey) {
        // Check if the session key exists in the map
        if (sessionMap.containsKey(sessionKey)) {
            // Return the user id from the map
            return sessionMap.get(sessionKey);
        } else {
            // Return null if the session key does not exist
            return null;
        }
    }

    // Method to validate if a session key is valid
    public boolean validateSession(String sessionKey) {
        // Check if the session key exists in the map
        return sessionMap.containsKey(sessionKey);
    }

    // Method to generate a session key
    private String generateSessionKey(String userId) {
        // Generate a session key by hashing the user id
        return String.valueOf(userId.hashCode());
    }
}