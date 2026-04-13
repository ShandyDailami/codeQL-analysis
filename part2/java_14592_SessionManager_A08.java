import java.util.concurrent.ConcurrentHashMap;

public class java_14592_SessionManager_A08 {
    private ConcurrentHashMap<String, Session> sessions;

    public java_14592_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
            return session;
        }
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_14592_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}