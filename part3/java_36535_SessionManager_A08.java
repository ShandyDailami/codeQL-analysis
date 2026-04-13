import java.util.HashMap;
import java.util.Map;

public class java_36535_SessionManager_A08 {
    // A HashMap to simulate a session storage.
    private Map<String, String> sessionMap;

    // Constructor
    public java_36535_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userName) {
        // Generate a session ID.
        String sessionId = userName + System.currentTimeMillis();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Verify the session ID.
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        // Remove the session from the session map.
        sessionMap.remove(sessionId);
    }
}