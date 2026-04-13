import java.util.HashMap;
import java.util.Map;

public class java_20737_SessionManager_A07 {
    private Map<String, Session> sessions;

    public java_20737_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void addSession(Session session) {
        this.sessions.put(session.getId(), session);
    }

    public Session getSession(String id) {
        return this.sessions.get(id);
    }

    public void removeSession(String id) {
        this.sessions.remove(id);
    }

    public static class Session {
        private String id;

        public java_20737_SessionManager_A07(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.addSession(new Session("session1"));
        Session session2 = sessionManager.addSession(new Session("session2"));

        sessionManager.getSession("session1");
        sessionManager.removeSession("session2");
    }
}