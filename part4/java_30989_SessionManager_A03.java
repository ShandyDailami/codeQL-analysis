import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_30989_SessionManager_A03 {
    private final Map<String, Session> sessions;

    public java_30989_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private final String sessionId;

        public java_30989_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}