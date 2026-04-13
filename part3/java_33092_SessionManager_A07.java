import java.util.HashMap;

public class java_33092_SessionManager_A07 {
    // A map for storing session data.
    private HashMap<String, Session> sessionMap;

    public java_33092_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the ID " + sessionId + " already exists");
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessionMap.remove(sessionId);
    }

    // Session class.
    public static class Session {
        private String id;

        public java_33092_SessionManager_A07(String id) {
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