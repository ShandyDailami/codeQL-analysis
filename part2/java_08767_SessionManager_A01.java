import java.util.HashMap;

public class java_08767_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, Session> sessions;

    // Constructor
    public java_08767_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String userId;
        private String sessionId;

        // Constructor
        public java_08767_SessionManager_A01(String userId, String sessionId) {
            this.userId = userId;
            this.sessionId = sessionId;
        }

        // Getters
        public String getUserId() {
            return userId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }

    // Create a new session
    public Session createSession(String userId, String sessionId) {
        Session session = new Session(userId, sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}