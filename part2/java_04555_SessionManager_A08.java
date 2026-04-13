import java.util.HashMap;
import java.util.Map;

public class java_04555_SessionManager_A08 {
    // Create a map to store session data
    private Map<String, Session> sessions = new HashMap<>();

    // Start a new session
    public Session startSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    // Get a session from the map
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Close a session from the map
    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    // A simple session class
    public class Session {
        private String id;

        // Create a new session
        public java_04555_SessionManager_A08() {
            this.id = java.util.UUID.randomUUID().toString();
        }

        // Get the session ID
        public String getId() {
            return id;
        }
    }
}