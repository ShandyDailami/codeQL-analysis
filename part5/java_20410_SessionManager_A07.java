import java.util.HashMap;
import java.util.Map;

public class java_20410_SessionManager_A07 {
    // Use a HashMap to store sessions.
    private Map<String, Session> sessions = new HashMap<>();

    // Session class.
    public class Session {
        private String userId;

        public java_20410_SessionManager_A07(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // Add a session for a user.
    public Session addSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Get the session for a user.
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Remove a session for a user.
    public void removeSession(String userId) {
        sessions.remove(userId);
    }
}