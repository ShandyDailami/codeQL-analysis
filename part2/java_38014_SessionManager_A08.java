import java.util.HashMap;
import java.util.Map;

public class java_38014_SessionManager_A08 {

    // A session map to hold user sessions
    private Map<String, Session> sessions;

    public java_38014_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session for a user
    public Session createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }

        Session session = new Session(userId);
        sessions.put(userId, session);

        return session;
    }

    // Method to get a session for a user
    public Session getSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }

        return sessions.get(userId);
    }

    // Session class
    private static class Session {
        private String userId;

        public java_38014_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }
}