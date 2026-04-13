import java.util.HashMap;
import java.util.Map;

public class java_28680_SessionManager_A07 {
    // A map to store sessions
    private Map<String, String> sessionMap;

    // Default constructor
    public java_28680_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the session ID and username in the map
        sessionMap.put(sessionId, username);

        // Return the session ID
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session ID is in the map
        if (sessionMap.containsKey(sessionId)) {
            // Return the username associated with the session ID
            return sessionMap.get(sessionId);
        } else {
            // If the session ID is not in the map, return null
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }
}