import java.util.HashMap;

public class java_36597_SessionManager_A03 {
    private HashMap<String, UserSession> sessionMap;

    public java_36597_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session for a user
    public UserSession createSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new IllegalStateException("User already has an active session.");
        }

        UserSession session = new UserSession(userId);
        sessionMap.put(userId, session);

        return session;
    }

    // Method to get the session for a user
    public UserSession getSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("No active session found for user.");
        }

        return sessionMap.get(userId);
    }

    // Class to represent a session for a user
    public class UserSession {
        private String userId;

        public java_36597_SessionManager_A03(String userId) {
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