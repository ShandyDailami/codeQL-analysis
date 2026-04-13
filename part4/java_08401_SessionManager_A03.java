import java.util.HashMap;

public class java_08401_SessionManager_A03 {
    // A map to store session objects
    private HashMap<String, Session> sessions = new HashMap<>();

    // A class to represent a session
    public class Session {
        private String sessionId;
        private String userId;

        public java_08401_SessionManager_A03(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }
    }

    // Method to create a new session
    public Session createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        Session session = new Session(sessionId, userId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session given the sessionId
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to close a session given the sessionId
    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}