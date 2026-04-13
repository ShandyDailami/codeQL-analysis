import java.util.HashMap;
import java.util.Map;

public class java_02035_SessionManager_A03 {
    // The sessions are stored in a HashMap.
    private Map<String, String> sessionMap;

    // Constructor
    public java_02035_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userId) {
        // Create a session ID using a user ID.
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Validate the session by checking if it's in the map.
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session.
    public void destroySession(String sessionId) {
        // Destroy a session by removing it from the map.
        sessionMap.remove(sessionId);
    }
}