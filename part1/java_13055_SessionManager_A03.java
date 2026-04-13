import java.util.HashMap;
import java.util.Map;

public class java_13055_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_13055_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            sessions.put(sessionId, new Session(sessionId));
        }
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String sessionId;

        public java_13055_SessionManager_A03(String sessionId) {
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