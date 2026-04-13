import java.util.HashMap;
import java.util.Map;

public class java_31368_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_31368_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("User already has a session.");
        }
        sessions.put(userId, sessionId);
    }

    public void validateSession(String userId, String sessionId) {
        if (!sessions.containsKey(userId) || !sessions.get(userId).equals(sessionId)) {
            throw new IllegalStateException("Invalid session.");
        }
    }

    public void deleteSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("No session found for user.");
        }
        sessions.remove(userId);
    }
}