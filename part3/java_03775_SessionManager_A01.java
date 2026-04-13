import java.util.HashMap;
import java.util.Map;

public class java_03775_SessionManager_A01 {
    // A map to hold user sessions.
    private Map<String, String> sessionMap;

    // Constructor.
    public java_03775_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String username) {
        // Create a session ID based on the username.
        String sessionId = username + System.currentTimeMillis();

        // Store the session ID and username in the map.
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId) {
        // Check if the session ID exists in the map.
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the username from a session.
    public String getUsername(String sessionId) {
        // Check if the session ID is valid.
        if (validateSession(sessionId)) {
            // Get the username from the session ID.
            return sessionMap.get(sessionId);
        }

        return null;
    }
}