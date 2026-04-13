import java.util.HashMap;
import java.util.Map;

public class java_21016_SessionManager_A08 {
    // Use a Map to store the sessions.
    private Map<String, Session> sessionMap;

    public java_21016_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a new session.
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Get a session.
    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Session not found");
        }
        return session;
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Inner class for a session.
    public class Session {
        private String sessionId;

        public java_21016_SessionManager_A08(String sessionId) {
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