import java.util.HashMap;
import java.util.Map;

public class java_04186_SessionManager_A08 {
    // Map to store session objects
    private Map<String, Session> sessions;

    public java_04186_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Create a session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Check if a session exists
    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_04186_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        // Simulate integrity failure
        public void integrityFailure() {
            throw new SecurityException("Integrity failure in session: " + id);
        }
    }
}