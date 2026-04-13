import java.util.HashMap;
import java.util.Map;

public class java_15707_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_15707_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void openSession(String sessionId, String userId) {
        if (sessionId == null || userId == null || sessionId.isEmpty() || userId.isEmpty()) {
            throw new IllegalArgumentException("Session ID and User ID must not be null or empty");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already open for user: " + userId);
        }
        sessions.put(sessionId, userId);
    }

    public String getUserIdForSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session found for session ID: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session found for session ID: " + sessionId);
        }
        sessions.remove(sessionId);
    }
}