import java.util.HashMap;
import java.util.Map;

public class java_07803_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_07803_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.put(sessionId, new Session());
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.remove(sessionId);
    }

    public class Session {
        // No fields or methods in this class - only a constructor and a void method
        public java_07803_SessionManager_A01() { }
    }
}