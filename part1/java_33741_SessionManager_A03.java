import java.util.HashMap;
import java.util.Map;

public class java_33741_SessionManager_A03 {
    // A map to store sessions.
    private Map<String, String> sessionMap;

    public java_33741_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to get the session by session ID.
    public String getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        return sessionMap.get(sessionId);
    }

    // Method to delete a session by session ID.
    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionMap.remove(sessionId);
    }
}