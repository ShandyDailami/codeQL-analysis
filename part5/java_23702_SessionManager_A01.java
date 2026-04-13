import java.util.HashMap;
import java.util.Map;

public class java_23702_SessionManager_A01 {
    // Map to store sessions. Key is session id, value is session.
    private Map<String, Session> sessionMap;

    public java_23702_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_23702_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}