import java.util.HashMap;

public class java_41190_SessionManager_A01 {
    // Using a HashMap to store sessions, where the key is the session ID and the value is the user
    private HashMap<String, User> sessions;

    public java_41190_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session for a user
    public String createSession(String userId) {
        // Generating a random session ID, it can be done later if needed
        String sessionId = "A01_BrokenAccessControl_" + userId;
        User user = new User(userId);
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session
    public User getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    // Class to hold user information
    private class User {
        private String userId;

        public java_41190_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}