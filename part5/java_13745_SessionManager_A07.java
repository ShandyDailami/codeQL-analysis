import java.util.HashMap;
import java.util.Map;

public class java_13745_SessionManager_A07 {

    // Create a HashMap to store the sessions.
    private Map<String, String> sessionMap;

    // Initialize the session map.
    public java_13745_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}