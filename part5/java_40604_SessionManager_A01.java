import java.util.HashMap;
import java.util.Map;

public class java_40604_SessionManager_A01 {
    // Create a map to store sessions. Each session is identified by a key.
    private Map<String, Session> sessions;

    public java_40604_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String id;
        private String userId;

        public java_40604_SessionManager_A01(String id, String userId) {
            this.id = id;
            this.userId = userId;
        }

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Method to create a new session
    public Session createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, userId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session based on session id
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to delete a session based on session id
    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to verify the access control of a session
    public boolean verifyAccessControl(String sessionId, String userId) {
        // Here we assume that if the session exists and the user is the same, the access is granted.
        Session session = sessions.get(sessionId);
        if (session != null && session.getUserId().equals(userId)) {
            return true;
        }
        return false;
    }
}