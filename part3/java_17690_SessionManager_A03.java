import java.util.HashMap;

public class java_17690_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_17690_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void destroySession(String id) {
        sessions.remove(id);
    }

    public static class Session {
        private String id;

        public java_17690_SessionManager_A03(String id) {
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