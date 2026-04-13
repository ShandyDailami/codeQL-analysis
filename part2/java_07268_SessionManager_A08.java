import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_07268_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_07268_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public String createSession(Session session) {
        String id = session.getId();
        sessions.put(id, session);
        return id;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void deleteSession(String id) {
        sessions.remove(id);
    }

    public void clearSessions() {
        sessions.clear();
    }

    private class Session {
        private String id;

        public java_07268_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}