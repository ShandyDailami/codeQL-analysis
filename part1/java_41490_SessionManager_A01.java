import java.util.HashMap;
import java.util.Map;

public class java_41490_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41490_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to retrieve a username from a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This method should generate a unique and random session ID
        // It's left as an exercise to the reader
        return null;
    }
}