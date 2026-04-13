import java.util.LinkedList;

public class java_41727_SessionManager_A01 {
    private LinkedList<Session> sessions;

    public java_41727_SessionManager_A01() {
        sessions = new LinkedList<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void destroySession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(String sessionId) {
        for (Session s : sessions) {
            if (s.getId().equals(sessionId)) {
                return s;
            }
        }
        return null;
    }

    public static class Session {
        private String id;

        public java_41727_SessionManager_A01() {
            this.id = UUID.randomUUID().toString(); // Generate a unique ID
        }

        public String getId() {
            return id;
        }
    }
}