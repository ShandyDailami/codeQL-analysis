import java.util.*;

public class java_03948_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_03948_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String username) {
        if (sessionId == null || sessionId.isEmpty() || username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Session ID and username must be provided");
        }
        sessions.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be provided");
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be provided");
        }
        sessions.remove(sessionId);
    }
}