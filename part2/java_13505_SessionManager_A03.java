import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_13505_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_13505_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String sessionId;

        public java_13505_SessionManager_A03(String sessionId) {
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