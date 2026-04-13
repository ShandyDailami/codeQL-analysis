import java.util.HashMap;
import java.util.Map;

public class java_19498_SessionManager_A01 {
    // Private field to hold sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_19498_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists!");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " does not exist!");
        }

        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_19498_SessionManager_A01(String id) {
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