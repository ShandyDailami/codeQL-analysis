import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_18563_SessionManager_A08 {
    private static final long serialVersionUID = 1L;

    private Map<String, Session> sessions = new ConcurrentHashMap<>();

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void putSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public void removeSession(String id) {
        sessions.remove(id);
    }

    public static class Session {
        private static final long serialVersionUID = 1L;

        private String id;

        public java_18563_SessionManager_A08(String id) {
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