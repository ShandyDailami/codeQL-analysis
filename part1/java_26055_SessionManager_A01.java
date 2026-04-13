import java.util.HashMap;
import java.util.Map;

public class java_26055_SessionManager_A01 {
    // Map to hold sessions.
    private Map<String, Session> sessions;

    // Session class.
    public class Session {
        private String id;

        public java_26055_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    public java_26055_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Create a new session.
    public Session createSession(String id) {
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    // Destroy a session.
    public void destroySession(String id) {
        sessions.remove(id);
    }

    // Get a session.
    public Session getSession(String id) {
        return sessions.get(id);
    }
}