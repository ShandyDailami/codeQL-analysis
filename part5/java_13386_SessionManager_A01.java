import java.util.HashMap;
import java.util.Map;

public class java_13386_SessionManager_A01 {
    // Create a HashMap for storing sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_13386_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method for creating a new session.
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method for retrieving a user from a session.
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method for invalidating a session.
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}