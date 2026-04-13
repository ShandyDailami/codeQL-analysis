import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_21407_SessionManager_A03 {
    // A map to hold user sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_21407_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a UUID for the session
        String sessionId = UUID.randomUUID().toString();

        // Store the session ID in the map
        sessionMap.put(sessionId, username);

        // Return the session ID
        return sessionId;
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        // Check if the session ID is in the map
        if (sessionMap.containsKey(sessionId)) {
            // Return the username
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }
}