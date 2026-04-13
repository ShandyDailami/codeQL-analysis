import java.util.HashMap;
import java.util.Map;

public class java_37693_SessionManager_A03 {
    // Static variable to store all active sessions
    private static Map<String, Session> sessions = new HashMap<>();

    // Session class
    public static class Session {
        private String userId;

        public java_37693_SessionManager_A03(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Method to create a new session
    public static Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    // Method to get a session
    public static Session getSession(String userId) {
        return sessions.get(userId);
    }
}