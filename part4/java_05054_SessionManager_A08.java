import java.util.HashMap;
import java.util.Map;

public class java_05054_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_05054_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            Session newSession = new Session(sessionId);
            sessions.put(sessionId, newSession);
            return newSession;
        }
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_05054_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        Session session = manager.getSession("123");
        session.setId("456");
        System.out.println(session.getId());
        manager.destroySession("123");
    }
}