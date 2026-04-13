import java.util.HashMap;
import java.util.Map;

public class java_35394_SessionManager_A07 {
    // Use a HasMap to store Session objects
    private Map<String, Session> sessions;

    public java_35394_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if sessionId is already taken
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " already exists");
        }

        // Create new session object and add to map
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get session
    public Session getSession(String sessionId) {
        // Check if sessionId is in the map
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " does not exist");
        }

        // Return session object
        return sessions.get(sessionId);
    }

    // Method to close session
    public void closeSession(String sessionId) {
        // Check if sessionId is in the map
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " does not exist");
        }

        // Remove session object from map
        sessions.remove(sessionId);
    }

    // Session class to store session information
    private class Session {
        private String id;

        public java_35394_SessionManager_A07(String id) {
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