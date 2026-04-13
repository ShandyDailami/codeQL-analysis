import java.util.concurrent.ConcurrentHashMap;

public class java_20050_SessionManager_A01 {
    // ConcurrentHashMap to store session information
    private ConcurrentHashMap<String, Session> sessionMap;

    // Initializing the ConcurrentHashMap
    public java_20050_SessionManager_A01() {
        sessionMap = new ConcurrentHashMap<>();
    }

    // Method to create a session
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists");
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist");
        }
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        Session session = sessionMap.remove(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session does not exist");
        }
    }

    // Inner class to represent a session
    public class Session {
        private String id;

        public java_20050_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}