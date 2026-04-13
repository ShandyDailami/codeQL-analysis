import java.util.HashMap;
import java.util.Map;

public class java_31026_SessionManager_A03 {

    private Map<String, Session> sessions;

    public java_31026_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session();
        session.setId(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void deleteSession(Session session) {
        sessions.remove(session.getId());
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}