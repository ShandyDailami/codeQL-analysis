import java.util.HashMap;
import java.util.Map;

public class java_34372_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_34372_SessionManager_A01() {
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

    public void closeSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        }
    }

    public static class Session {
        private String id;

        public java_34372_SessionManager_A01(String id) {
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