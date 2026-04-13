import java.util.HashMap;
import java.util.Map;

public class java_00224_SessionManager_A07 {

    // Map to hold sessions
    private Map<String, Session> sessions;

    public java_00224_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String userId;

        public java_00224_SessionManager_A07(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // Method to create a new session
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Method to retrieve a session
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Method to invalidate a session
    public void invalidateSession(String userId) {
        sessions.remove(userId);
    }
}