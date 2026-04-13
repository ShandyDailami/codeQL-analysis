import java.util.HashMap;
import java.util.Map;

public class java_07897_SessionManager_A07 {

    // A private map to hold all sessions.
    private Map<String, Session> sessionMap;

    // Default constructor.
    public java_07897_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            return session;
        }
    }

    // Method to get a session.
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Session class.
    private class Session {

        private String sessionId;

        public java_07897_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return this.sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}