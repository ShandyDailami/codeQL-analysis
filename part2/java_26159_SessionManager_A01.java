import java.util.HashMap;
import java.util.Map;

public class java_26159_SessionManager_A01 {
    // Define a map to store session data.
    private Map<String, String> sessionMap;

    // Initialize the session map.
    public java_26159_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session.
    public void addSession(String sessionId, String userId) {
        // Check if the session ID is unique.
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID already exists.");
        }

        // Add the session to the map.
        sessionMap.put(sessionId, userId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        // Check if the session ID exists.
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID does not exist.");
        }

        // Remove the session from the map.
        sessionMap.remove(sessionId);
    }

    // Method to get the user ID of a session.
    public String getUserId(String sessionId) {
        // Check if the session ID exists.
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session ID does not exist.");
        }

        // Return the user ID.
        return sessionMap.get(sessionId);
    }
}