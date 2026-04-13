import java.util.HashMap;
import java.util.Map;

public class java_02557_SessionManager_A01 {
    // A map to store sessions.
    private Map<String, Session> sessions;

    // Default constructor to initialize the map.
    public java_02557_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class.
    public class Session {
        // Id of the session.
        private String id;

        // Default constructor.
        public java_02557_SessionManager_A01() {
            this.id = UUID.randomUUID().toString();
        }

        // Method to get the id of the session.
        public String getId() {
            return id;
        }

        // Method to set the id of the session.
        public void setId(String id) {
            this.id = id;
        }
    }
}