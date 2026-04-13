import java.util.HashMap;
import java.util.Map;

public class java_01948_SessionManager_A08 {
    // Data structure to hold sessions
    private Map<String, Session> sessions;

    public java_01948_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get an existing session
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && session.isValid()) {
            return session;
        } else {
            throw new SecurityException("Session integrity failure: Session " + sessionId + " is not valid.");
        }
    }

    // Session class
    private class Session {
        private String id;
        private boolean valid;

        public java_01948_SessionManager_A08(String id) {
            this.id = id;
            this.valid = true; // Assume valid session
        }

        public boolean isValid() {
            return valid;
        }

        public void close() {
            valid = false; // Mark session as invalid
        }
    }
}