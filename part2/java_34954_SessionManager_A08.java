import java.util.HashMap;
import java.util.Map;

public class java_34954_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_34954_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        this.sessions.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return this.sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        this.sessions.remove(sessionId);
    }
}