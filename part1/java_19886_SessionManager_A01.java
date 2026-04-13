import java.util.HashMap;
import java.util.Map;

public class java_19886_SessionManager_A01 {
    // A simple in-memory store for sessions
    private Map<String, Session> sessions = new HashMap<>();

    // Session class
    public class Session {
        private String userId;

        public java_19886_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Create a new session
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Get the session for a given user
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Remove the session for a given user
    public void removeSession(String userId) {
        sessions.remove(userId);
    }
}