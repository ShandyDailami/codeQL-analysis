import java.util.HashMap;
import java.util.Map;

public class java_35503_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_35503_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void addSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public class Session {
        private String id;

        public java_35503_SessionManager_A03(String id) {
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