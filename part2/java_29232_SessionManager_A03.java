import java.util.HashMap;
import java.util.Map;

public class java_29232_SessionManager_A03 {

    // Map to store sessions
    private Map<String, Session> sessions;

    public java_29232_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Create a new session
    public Session createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Get the session for a user
    public Session getSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        return sessions.get(userId);
    }

    // Remove the session for a user
    public void removeSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        sessions.remove(userId);
    }

    // Session class
    public class Session {
        private String userId;

        public java_29232_SessionManager_A03(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void closeSession() {
            // In a secure manner, make sure to remove the session from the sessions map
            SessionManager.this.removeSession(userId);
        }
    }
}