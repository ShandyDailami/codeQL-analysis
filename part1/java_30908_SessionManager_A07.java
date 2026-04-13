import java.util.HashMap;
import java.util.Map;

public class java_30908_SessionManager_A07 {
    // Define a map to hold sessions
    private Map<String, String> sessionMap;

    // Constructor to initialize the session map
    public java_30908_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Generate a unique session ID and store it in the map
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId) {
        // Check if the session ID is in the map
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user ID from a session
    public String getUserIdFromSession(String sessionId) {
        // Check if the session ID is valid
        if (validateSession(sessionId)) {
            // Return the user ID from the session map
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}