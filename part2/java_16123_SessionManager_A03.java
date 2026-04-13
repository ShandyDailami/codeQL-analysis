import java.util.HashMap;
import java.util.Map;

public class java_16123_SessionManager_A03 {
    // Private instance of HashMap to store sessions
    private Map<String, Session> sessions;

    // Initialize the sessions
    public java_16123_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Object user) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(user, sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Session class
    private static class Session {
        private Object user;
        private String sessionId;

        public java_16123_SessionManager_A03(Object user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        // Getters
        public Object getUser() {
            return user;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}