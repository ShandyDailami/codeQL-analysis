import java.util.HashMap;
import java.util.Map;

public class java_11253_SessionManager_A01 {
    // Define a map to store sessions
    private Map<String, Session> sessionMap;

    public java_11253_SessionManager_A01() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    // Session class
    private class Session {
        private String sessionId;

        public java_11253_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}