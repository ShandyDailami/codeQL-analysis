import java.util.concurrent.ConcurrentHashMap;

public class java_29697_SessionManager_A03 {

    private ConcurrentHashMap<String, Session> sessions;

    public java_29697_SessionManager_A03() {
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
        private String sessionId;

        public java_29697_SessionManager_A03(String sessionId) {
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