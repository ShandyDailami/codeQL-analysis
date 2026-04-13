import java.util.HashMap;
import java.util.Map;

public class java_38176_SessionManager_A03 {
    // A map to hold the sessions
    private Map<String, Session> sessionMap;

    public java_38176_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_38176_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    // Method to create a session
    public Session createSession() {
        String sessionId = "session" + System.currentTimeMillis();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // If the session is not found, return null
            return null;
        }
    }
}