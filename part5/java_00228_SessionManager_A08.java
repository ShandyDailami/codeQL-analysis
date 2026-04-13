import java.util.HashMap;
import java.util.Map;

public class java_00228_SessionManager_A08 {
    // A map that will hold our sessions, using session IDs as keys.
    private Map<String, Session> sessions;

    // Constructor
    public java_00228_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Check if a session with this ID already exists.
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("A session with this ID already exists");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to retrieve a session.
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Check if a session with this ID exists.
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with this ID exists");
        }

        return sessions.get(sessionId);
    }

    // Session class
    private static class Session {
        private String id;

        public java_00228_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}