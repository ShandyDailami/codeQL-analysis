// Import the necessary libraries
import java.util.HashMap;
import java.util.Map;

public class java_42079_SessionManager_A08 {

    // Create a private map to store session objects
    private Map<String, Session> sessions;

    // Default constructor
    public java_42079_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session with ID " + sessionId + " already exists.");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session by its ID
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with ID " + sessionId + " exists.");
        }
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_42079_SessionManager_A08(String id) {
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