import java.util.HashMap;
import java.util.Map;

public class java_22621_SessionManager_A07 {
    // Session is a map that stores users' session information
    private Map<String, Session> sessions;

    public java_22621_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Session represents the information associated with a user
    public class Session {
        private String userName;
        private String userId;

        public java_22621_SessionManager_A07(String userName, String userId) {
            this.userName = userName;
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Method to create a new session for a user
    public Session createSession(String userName, String userId) {
        Session session = new Session(userName, userId);
        sessions.put(userId, session);
        return session;
    }

    // Method to check if a session exists for a given user
    public boolean checkSession(String userId) {
        return sessions.containsKey(userId);
    }

    // Method to get the session information for a given user
    public Session getSession(String userId) {
        return sessions.get(userId);
    }

    // Method to close the session for a given user
    public void closeSession(String userId) {
        sessions.remove(userId);
    }
}