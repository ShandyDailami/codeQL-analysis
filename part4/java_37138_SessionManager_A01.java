import java.util.HashMap;

public class java_37138_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_37138_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        sessions.put(session.getId(), session);
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void removeSession(String id) {
        sessions.remove(id);
    }

    public static class Session {
        private String id;

        public java_37138_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}