import java.util.HashMap;
import java.util.Map;

public class java_35137_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_35137_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String sessionId;

        public java_35137_SessionManager_A01(String sessionId) {
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