import java.util.HashMap;
import java.util.Map;

public class java_38473_SessionManager_A03 {
    // Create a HashMap to store the sessions.
    private Map<String, Session> sessions;

    // Initialize the sessions map.
    public java_38473_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Create a new session.
    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    // Get a session from the map.
    public Session getSession(String id) {
        return sessions.get(id);
    }

    // Session class.
    public class Session {
        private String id;

        // Create a new session.
        public java_38473_SessionManager_A03() {
            this.id = java.util.UUID.randomUUID().toString();
        }

        // Get the session id.
        public String getId() {
            return id;
        }
    }
}