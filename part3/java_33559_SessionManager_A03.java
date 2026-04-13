import java.util.HashMap;

public class java_33559_SessionManager_A03 {
    private HashMap<String, User> sessions;

    public java_33559_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String startSession(String userId) {
        String sessionId = generateSessionId();
        User user = new User(userId);
        sessions.put(sessionId, user);
        return sessionId;
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId).getUserId();
        }
        return null;
    }

    private String generateSessionId() {
        // This is a placeholder for generating a secure session id.
        // In a real application, this would require cryptography and possibly persistence.
        return "sessionId";
    }

    private class User {
        private String userId;

        public java_33559_SessionManager_A03(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }
}