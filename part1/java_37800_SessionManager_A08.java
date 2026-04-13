import java.util.HashMap;
import java.util.Map;

public class java_37800_SessionManager_A08 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_37800_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session ID
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user ID from a session
    public String getUserId(String sessionId) {
        // Verify the session ID and return the user ID
        return sessionMap.get(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID exists in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }
}