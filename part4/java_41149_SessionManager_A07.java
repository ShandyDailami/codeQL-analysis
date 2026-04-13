import java.util.HashMap;
import java.util.Map;

public class java_41149_SessionManager_A07 {

    // Create a map to store sessions.
    private Map<String, String> sessionMap = new HashMap<>();

    // Attempt to create a session.
    public void createSession(String sessionId, String userId) {
        // If sessionId already exists, remove it.
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }

        // Set the sessionId attribute.
        sessionMap.put(sessionId, userId);
    }

    // Attempt to access a session.
    public String accessSession(String sessionId) {
        // If sessionId doesn't exist, return null.
        if (!sessionMap.containsKey(sessionId)) {
            return null;
        }

        // Return the userId from the session.
        return sessionMap.get(sessionId);
    }

    // Attempt to invalidate a session.
    public void invalidateSession(String sessionId) {
        // If sessionId doesn't exist, do nothing.
        if (!sessionMap.containsKey(sessionId)) {
            return;
        }

        // Remove the sessionId attribute.
        sessionMap.remove(sessionId);
    }
}