import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_26612_SessionManager_A01 {
    // Create a concurrent map to store sessions
    private final Map<String, Session> sessions;

    public java_26612_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
    }

    // Create a session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    private class Session {
        private final String sessionId;

        private java_26612_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}