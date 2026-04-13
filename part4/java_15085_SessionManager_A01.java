import java.util.HashMap;
import java.util.Map;

public class java_15085_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_15085_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        // This is a placeholder for real implementations.
        // It includes a random session ID generation, which is not secure against known attacks.
        String sessionId = String.valueOf(userId.hashCode());
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkSessionValidity(String sessionId) {
        if (sessionId == null || !sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID.");
        }
    }
}