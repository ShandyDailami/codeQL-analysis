import java.util.HashMap;
import java.util.Map;

public class java_26305_SessionManager_A03 {
    // Private instance variables
    private Map<String, Session> sessions;

    // Constructor
    public java_26305_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Public methods
    public Session getSession(String sessionId) {
        // Validate sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("sessionId must not be null or empty");
        }

        // Retrieve session from map
        Session session = sessions.get(sessionId);

        // Create new session if not exists
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }

        return session;
    }

    public void destroySession(String sessionId) {
        // Validate sessionId
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("sessionId must not be null or empty");
        }

        // Remove session from map
        sessions.remove(sessionId);
    }

    // Inner class
    private static class Session {
        private String id;

        public java_26305_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}