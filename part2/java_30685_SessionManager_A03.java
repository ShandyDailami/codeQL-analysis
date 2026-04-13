import java.util.HashMap;
import java.util.Map;

public class java_30685_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_30685_SessionManager_A03() {
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

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_30685_SessionManager_A03(String id) {
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