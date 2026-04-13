import java.util.HashMap;
import java.util.Map;

public class java_17765_SessionManager_A07 {
    // Define a map to hold sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_17765_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a unique session key
        String sessionKey = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionKey, username);
        return sessionKey;
    }

    // Method to get the username from a session
    public String getUsername(String sessionKey) {
        // Check if the session key exists in the map
        if (sessionMap.containsKey(sessionKey)) {
            // Return the username from the session key
            return sessionMap.get(sessionKey);
        } else {
            // If the session key does not exist, return null
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionKey) {
        // Remove the session key from the map
        sessionMap.remove(sessionKey);
    }
}