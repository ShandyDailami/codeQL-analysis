import java.util.HashMap;
import java.util.Map;

public class java_22652_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_22652_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session openSession() {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void closeSession(String id) {
        sessions.remove(id);
    }

    private class Session {
        private String id;

        public java_22652_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}