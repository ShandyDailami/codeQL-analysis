import java.util.HashMap;
import java.util.Map;

public class java_13688_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_13688_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_13688_SessionManager_A01(String sessionId) {
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