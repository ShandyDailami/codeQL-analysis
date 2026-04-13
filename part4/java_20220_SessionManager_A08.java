// Import required packages
import java.util.HashMap;
import java.util.Map;

public class java_20220_SessionManager_A08 {
    // Create a map to store sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_20220_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if the session ID is already in use
        if (this.sessions.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the ID " + sessionId + " already exists.");
        }

        // Create a new session and store it in the map
        Session session = new Session(sessionId);
        this.sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Check if the session ID exists in the map
        if (!this.sessions.containsKey(sessionId)) {
            throw new IllegalStateException("No session with the ID " + sessionId + " exists.");
        }

        // Get the session from the map
        return this.sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_20220_SessionManager_A08(String id) {
            this.id = id;
        }

        // Getters and setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}