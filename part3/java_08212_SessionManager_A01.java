import java.util.HashMap;
import java.util.Map;

public class java_08212_SessionManager_A01 {
    // private Map to store sessions
    private Map<String, Session> sessions;

    public java_08212_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists for this ID: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get an existing session
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists for this ID: " + sessionId);
        }
        return session;
    }

    // Session class
    private class Session {
        private String id;

        public java_08212_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        // Add other methods as required...
    }
}