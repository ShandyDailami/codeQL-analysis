import java.util.HashMap;
import java.util.Map;

public class java_25938_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_25938_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessions.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_25938_SessionManager_A01(String sessionId) {
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