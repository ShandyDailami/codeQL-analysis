import java.util.HashMap;
import java.util.Map;

public class java_08417_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_08417_SessionManager_A07() {
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

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_08417_SessionManager_A07(String id) {
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