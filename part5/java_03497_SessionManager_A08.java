import java.util.HashMap;
import java.util.Map;

public class java_03497_SessionManager_A08 {
    // Store sessions in a map. Key is session ID, Value is session object.
    private Map<String, Session> sessionMap;

    public java_03497_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a new session. Return session ID.
    public String createSession(User user) {
        String sessionId = user.getUsername() + System.currentTimeMillis(); // For simplicity, use user's username and current time in milliseconds.
        sessionMap.put(sessionId, new Session(user, sessionId));
        return sessionId;
    }

    // Get the session object based on session ID.
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session based on session ID.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class.
    private class Session {
        private User user;
        private String sessionId;

        public java_03497_SessionManager_A08(User user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        // Getters and setters for user and sessionId.
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    // User class.
    private class User {
        private String username;

        public java_03497_SessionManager_A08(String username) {
            this.username = username;
        }

        // Getters and setters for username.
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}