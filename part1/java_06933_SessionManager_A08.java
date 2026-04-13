import java.util.HashSet;

public class java_06933_SessionManager_A08 {
    private HashSet<Session> sessions;

    public java_06933_SessionManager_A08() {
        sessions = new HashSet<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    private static class Session {
        private String id;

        public java_06933_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}