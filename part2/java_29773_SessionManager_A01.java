import java.util.HashMap;
import java.util.Map;

public class java_29773_SessionManager_A01 {
    // Define a map to store sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_29773_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String userId;

        // Constructor
        public java_29773_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        // Getter and Setter for userId
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

    // Method to validate a session
    public Session validateSession(String userId, String sessionId) {
        // Here we are assuming that if userId is null, session is invalid
        if (userId == null) {
            return null;
        }

        // Here we are assuming that sessionId is the userId of the session
        Session session = sessions.get(userId);
        if (session != null && session.getUserId().equals(sessionId)) {
            return session;
        }

        return null;
    }
}