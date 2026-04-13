import java.util.HashMap;

public class java_39892_SessionManager_A08 {

    // A HashMap to store sessions.
    private static HashMap<String, Session> sessions = new HashMap<>();

    // A Session class to encapsulate session data and methods.
    public static class Session {
        private String userId;

        public java_39892_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // Method to create a new session.
    public static Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Method to retrieve a session.
    public static Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Method to remove a session.
    public static void removeSession(String userId) {
        sessions.remove(userId);
    }
}