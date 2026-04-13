import java.util.HashMap;

public class java_02807_SessionManager_A08 {

    private HashMap<String, Session> sessions;

    public java_02807_SessionManager_A08() {
        sessions = new HashMap<String, Session>();
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

    // Session class for session management
    private class Session {
        private String id;

        public java_02807_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}