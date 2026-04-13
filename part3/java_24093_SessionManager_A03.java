import java.util.concurrent.ConcurrentHashMap;

public class java_24093_SessionManager_A03 {

    private ConcurrentHashMap<String, Session> sessions;

    public java_24093_SessionManager_A03() {
        sessions = new ConcurrentHashMap<>();
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

    public class Session {

        private String sessionId;

        public java_24093_SessionManager_A03(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}