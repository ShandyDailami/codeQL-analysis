import java.util.HashMap;

public class java_10604_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_10604_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void putSession(String sessionId, Session session) {
        sessions.put(sessionId, session);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_10604_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        Session session1 = new SessionManager.Session("session1");
        manager.putSession("session1", session1);

        Session session2 = manager.getSession("session1");
        System.out.println(session2.getId()); // should print "session1"

        manager.removeSession("session1");
        session2 = manager.getSession("session1");
        System.out.println(session2); // should print null
    }
}