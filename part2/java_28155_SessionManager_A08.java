import java.util.HashMap;
import java.util.Map;

public class java_28155_SessionManager_A08 {
    // Use a HashMap to simulate a database
    private Map<String, String> sessions;

    public java_28155_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Create a random sessionId for the user
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Validate the sessionId (check if it exists in the map)
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        }
        return null;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Delete the session from the map
        sessions.remove(sessionId);
    }
}