import java.util.HashMap;
import java.util.Map;

public class java_17489_SessionManager_A07 {
    // Create a map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_17489_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a session id using user id
        String sessionId = userId + System.currentTimeMillis();

        // Store the session id with user id
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the map
        if (sessionMap.containsKey(sessionId)) {
            // If it does, return the user id associated with the session id
            return sessionMap.get(sessionId);
        } else {
            // If not, return null to indicate a failed authentication
            return null;
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Remove the session id from the map
        sessionMap.remove(sessionId);
    }
}