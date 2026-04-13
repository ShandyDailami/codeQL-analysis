import java.util.HashMap;
import java.util.Map;

public class java_34277_SessionManager_A08 {
    // A HashMap to store sessions
    private Map<String, Session> sessions;

    public java_34277_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session not found");
        }
        return session;
    }

    // Destroy a session
    public void destroySession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session not found");
        }
    }

    // Session class
    private class Session {
        private String sessionId;

        public java_34277_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}