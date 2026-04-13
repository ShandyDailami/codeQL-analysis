import java.util.HashMap;
import java.util.Map;

public class java_37996_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_37996_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void invalidateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String id;

        public java_37996_SessionManager_A01(String id) {
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