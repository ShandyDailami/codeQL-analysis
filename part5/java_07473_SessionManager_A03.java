import java.util.HashMap;

public class java_07473_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_07473_SessionManager_A03() {
        sessions = new HashMap<>();
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

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_07473_SessionManager_A03(String id) {
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