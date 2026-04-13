import java.util.HashMap;
import java.util.Map;

public class java_18140_SessionManager_A03 {
    // Define a HashMap to store session IDs and session objects
    private Map<String, Session> sessions;

    // Initialize the HashMap
    public java_18140_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Get a session by its ID
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Remove a session by its ID
    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Session class
    private static class Session {
        private String id;

        public java_18140_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}