import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_40615_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_40615_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String sessionId;

        public java_40615_SessionManager_A01(String sessionId) {
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