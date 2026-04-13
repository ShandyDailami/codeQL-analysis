import java.util.HashMap;
import java.util.Map;

public class java_11578_SessionManager_A03 {
    // Map to store sessions
    private Map<String, Session> sessions;

    public java_11578_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }
        return sessions.get(sessionId);
    }

    // Session class
    private static class Session {
        private String id;

        public java_11578_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}