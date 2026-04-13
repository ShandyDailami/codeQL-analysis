import java.util.HashMap;
import java.util.Map;

public class java_26677_SessionManager_A07 {
    // Map to store sessions.
    private Map<String, Session> sessions;

    public java_26677_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }
        Session session = new Session();
        session.setId(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }
        return sessions.get(sessionId);
    }

    // Session class.
    public class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}