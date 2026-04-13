import java.util.concurrent.ConcurrentHashMap;

public class java_09980_SessionManager_A03 {
    // The session map
    private ConcurrentHashMap<String, Session> sessionMap;

    public java_09980_SessionManager_A03() {
        // Create a new session map
        sessionMap = new ConcurrentHashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if session already exists
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }

        // Create a new session and add it to the map
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if session exists
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session exists with id: " + sessionId);
       
        }

        // Get the session from the map
        Session session = sessionMap.get(sessionId);

        return session;
    }

    // Session class
    private class Session {
        private String id;

        public java_09980_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}