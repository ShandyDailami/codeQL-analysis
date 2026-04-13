import java.util.HashMap;
import java.util.Map;

public class java_32532_SessionManager_A07 {
    // Create a map to store session IDs and sessions
    private Map<String, Session> sessions;

    // Initialization of the map
    public java_32532_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // Create a new session ID
        String sessionId = UUID.randomUUID().toString();

        // Create a new session
        Session session = new Session(sessionId, userId);

        // Add the session to the map
        sessions.put(sessionId, session);

        // Return the session ID
        return sessionId;
    }

    // Method to retrieve a session
    public Session getSession(String sessionId) {
        // Return the session
        return sessions.get(sessionId);
    }

    // Session class to hold session details
    private class Session {
        private String sessionId;
        private String userId;

        // Session constructor
        private java_32532_SessionManager_A07(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        // Getters
        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }
    }
}