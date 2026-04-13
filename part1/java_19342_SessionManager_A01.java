import java.util.HashMap;

public class java_19342_SessionManager_A01 {
    // This is a simple implementation of a session map
    // In a real-world application, a more sophisticated session management system would use a database or other persistent storage.
    private HashMap<String, Session> sessions = new HashMap<>();

    // Session class
    public class Session {
        private String userId;

        public java_19342_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // Create a session
    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Get the session
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Remove the session
    public void removeSession(String userId) {
        sessions.remove(userId);
    }
}