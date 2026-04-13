import java.util.HashMap;

public class java_38191_SessionManager_A01 {
    // Store all sessions
    private HashMap<String, Session> sessions = new HashMap<>();

    // Create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
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

    // Session class
    private class Session {
        private String id;

        public java_38191_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}