import java.util.HashMap;

public class java_39579_SessionManager_A03 {
    // A HashMap that will store sessions. The key will be the session ID and the value is the session object.
    private HashMap<String, Session> sessions;

    public java_39579_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Create a new session. The session ID is automatically generated.
    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getSessionId(), session);
        return session;
    }

    // Get a session based on the session ID.
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Remove a session based on the session ID.
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // The Session class is a simple POJO that holds the session ID.
    public class Session {
        private String sessionId;

        public java_39579_SessionManager_A03() {
            this.sessionId = java.util.UUID.randomUUID().toString(); // Generate a new session ID.
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}