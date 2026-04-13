import java.util.HashMap;
import java.util.Map;

public class java_04571_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_04571_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public class Session {
        private String sessionId;

        public java_04571_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void invalidate() {
            SessionManager.this.closeSession(sessionId);
        }
    }
}