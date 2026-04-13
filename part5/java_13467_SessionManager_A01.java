import java.util.HashMap;
import java.util.Map;

public class java_13467_SessionManager_A01 {
    // A map to store sessions. Key is session id, value is the session.
    private Map<String, Session> sessions;

    public java_13467_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // A session represents a client connection.
    public class Session {
        private String id;

        public java_13467_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    // Create a new session.
    public Session createSession() {
        String id = "session-" + System.currentTimeMillis();
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Get a session by id.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Remove a session by id.
    public void destroySession(String id) {
        sessions.remove(id);
    }
}