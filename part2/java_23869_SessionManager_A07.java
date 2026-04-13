import java.util.HashMap;
import java.util.Map;

public class java_23869_SessionManager_A07 {
    // A map to store sessions. Key is session ID, value is session object.
    private Map<String, Session> sessions;

    public java_23869_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        return session;
    }

    // Session class.
    private class Session {
        private String sessionId;

        public java_23869_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}