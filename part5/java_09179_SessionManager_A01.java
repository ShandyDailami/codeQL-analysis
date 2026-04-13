import java.util.HashMap;
import java.util.Map;

public class java_09179_SessionManager_A01 {
    // Use a Map to store sessions. The key is the session id, and the value is the session object.
    private Map<String, Session> sessions;

    // Constructor
    public java_09179_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if sessionId is already in use
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }

        // Create a new Session object and add it to the map
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session by session id
    public Session getSession(String sessionId) {
        // Check if sessionId is valid
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
        }

        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_09179_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        // Add other session methods here (like login, logout, update, etc.)
    }
}