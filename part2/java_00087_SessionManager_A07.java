import java.util.HashMap;
import java.util.Map;

public class java_00087_SessionManager_A07 {

    // Simple in-memory data store for storing sessions.
    private Map<String, Session> sessions = new HashMap<>();

    // Session class.
    public class Session {
        private String userId;

        public java_00087_SessionManager_A07(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Method to create a new session.
    public String createSession(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Create a new session and store it in the in-memory data store.
        Session session = new Session(userId);
        sessions.put(session.getUserId(), session);

        return session.getUserId();
    }

    // Method to get the session.
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Retrieve the session from the in-memory data store.
        return sessions.get(sessionId);
    }

    // Method to delete the session.
    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Delete the session from the in-memory data store.
        sessions.remove(sessionId);
    }
}