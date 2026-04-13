import java.util.HashMap;

public class java_11882_SessionManager_A08 {
    // Using HashMap to store sessions
    private HashMap<String, User> sessions;

    public java_11882_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(User user) {
        String sessionId = user.getUserId();
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session
    public User getUserFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // User class
    public class User {
        private String userId;
        private String username;

        public java_11882_SessionManager_A08(String userId, String username) {
            this.userId = userId;
            this.username = username;
        }

        public String getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }
    }
}