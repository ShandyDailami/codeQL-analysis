import java.util.HashMap;
import java.util.Map;

public class java_08099_SessionManager_A08 {
    // Create a HashMap to store sessions
    private Map<String, Session> sessionMap;

    public java_08099_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    // Get a session
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_08099_SessionManager_A08(String sessionId) {
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