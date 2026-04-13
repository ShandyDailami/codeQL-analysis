import java.util.HashMap;
import java.util.Map;

public class java_35640_SessionManager_A07 {

    // Map to hold sessions. Key is session id, value is the session.
    private Map<String, Session> sessions;

    public java_35640_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    // Create a new session.
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session id must not be null or empty");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session with id " + sessionId + " already exists");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session.
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session id must not be null or empty");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Session with id " + sessionId + " does not exists");
        }
        return session;
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session id must not be null or empty");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Session with id " + sessionId + " does not exists");
        }
        sessions.remove(sessionId);
    }

    // Session class.
    private class Session {
        private String id;

        public java_35640_SessionManager_A07(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}