import java.util.HashMap;
import java.util.Map;

public class java_15917_SessionManager_A07 {

    // Create a HashMap to store session data.
    private Map<String, String> sessionMap = new HashMap<>();

    // Method to start a new session.
    public String startSession(String username) {
        // Generate a session ID.
        String sessionId = generateSessionId(username);

        // Store the session ID in the map.
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Check if the session ID is in the map.
        if (sessionMap.containsKey(sessionId)) {
            // Return the username associated with the session ID.
            return sessionMap.get(sessionId);
        } else {
            // If the session ID is not in the map, return null.
            return null;
        }
    }

    // Method to end a session.
    public void endSession(String sessionId) {
        // Remove the session ID from the map.
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a session ID.
    private String generateSessionId(String username) {
        // You can use a hash function here.
        return String.valueOf(username.hashCode());
    }
}