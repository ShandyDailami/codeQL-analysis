import java.util.HashMap;
import java.util.Map;

public class java_27629_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_27629_SessionManager_A01() {
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

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_27629_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void invalidate() {
            SessionManager.this.removeSession(id);
        }
    }
}