import java.util.HashMap;
import java.util.Map;

public class java_04216_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_04216_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    private class Session {
        private String id;

        public java_04216_SessionManager_A08(String id) {
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