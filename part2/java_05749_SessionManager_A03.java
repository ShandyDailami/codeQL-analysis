import java.util.HashMap;
import java.util.Map;

public class java_05749_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_05749_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_05749_SessionManager_A03(String sessionId) {
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