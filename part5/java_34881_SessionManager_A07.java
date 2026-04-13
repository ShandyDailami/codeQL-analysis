import java.util.HashMap;
import java.util.Map;

public class java_34881_SessionManager_A07 {
    // Define a private map to store sessions
    private Map<String, Session> sessions;

    // Define a Session class
    public class Session {
        private String userId;
        private String userName;

        // Constructor
        public java_34881_SessionManager_A07(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        // Getters
        public String getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }
    }

    // Constructor
    public java_34881_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String userId, String userName) {
        Session session = new Session(userId, userName);
        this.sessions.put(userId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String userId) {
        return this.sessions.get(userId);
    }
}