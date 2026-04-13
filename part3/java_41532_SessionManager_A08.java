import java.util.HashMap;

public class java_41532_SessionManager_A08 {
    // The session storage.
    private HashMap<String, Session> sessions = new HashMap<>();

    // A session represents a user's session with a web browser.
    public static class Session {
        private String id;

        // Constructor
        public java_41532_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    // Add a session
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
}