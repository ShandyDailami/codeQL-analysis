import java.util.HashMap;

public class java_38192_SessionManager_A01 {
    // A HashMap to store user sessions
    private HashMap<String, UserSession> sessions;

    public java_38192_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session for a user
    public UserSession createSession(String userId) {
        if (sessions.containsKey(userId)) {
            throw new IllegalStateException("User already has a session.");
        }

        UserSession session = new UserSession(userId);
        sessions.put(userId, session);

        return session;
    }

    // Method to get a session for a user
    public UserSession getSession(String userId) {
        if (!sessions.containsKey(userId)) {
            throw new IllegalStateException("User does not have a session.");
        }

        return sessions.get(userId);
    }

    // UserSession class (simplified for this example)
    public class UserSession {
        private String userId;

        public java_38192_SessionManager_A01(String userId) {
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