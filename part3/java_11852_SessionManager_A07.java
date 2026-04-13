import java.util.HashMap;
import java.util.Map;

public class java_11852_SessionManager_A07 {
    // Create a Map to store sessions.
    private Map<String, Session> sessions;

    public java_11852_SessionManager_A07() {
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
        return sessions.get(sessionId);
    }

    // Session class.
    class Session {
        private String id;

        public java_11852_SessionManager_A07(String id) {
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