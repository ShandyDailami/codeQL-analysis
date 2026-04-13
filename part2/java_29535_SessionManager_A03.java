import java.util.HashMap;
import java.util.Map;

public class java_29535_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_29535_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void updateSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public class Session {
        private String id;

        public java_29535_SessionManager_A03(String id) {
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