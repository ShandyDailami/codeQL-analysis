import java.util.HashMap;
import java.util.UUID;

public class java_25167_SessionManager_A07 {
    // Data structure for storing sessions.
    private HashMap<String, Session> sessions;

    public java_25167_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Creates a new session if one doesn't already exist.
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Retrieves a session by its ID.
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            // If session doesn't exist, return null.
            return null;
        }
        // If session exists, return it.
        return sessions.get(sessionId);
    }

    // Removes a session by its ID.
    public void removeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    // Session represents a user session.
    public static class Session {
        private String sessionId;

        public java_25167_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}