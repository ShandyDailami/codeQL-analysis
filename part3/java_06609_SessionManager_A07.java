import java.util.HashMap;
import java.util.Map;

public class java_06609_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_06609_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            Session session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_06609_SessionManager_A07(String id) {
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