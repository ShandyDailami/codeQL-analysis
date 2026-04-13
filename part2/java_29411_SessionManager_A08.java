import java.util.HashSet;
import java.util.UUID;

public class java_29411_SessionManager_A08 {

    private HashSet<Session> sessions;

    public java_29411_SessionManager_A08() {
        sessions = new HashSet<Session>();
    }

    public Session createSession() {
        Session session = new Session(UUID.randomUUID().toString());
        sessions.add(session);
        return session;
    }

    public Session getSession(String sessionId) {
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null; // Return null if session not found
    }

    public void destroySession(String sessionId) {
        sessions.removeIf(session -> session.getId().equals(sessionId));
    }

    public class Session {

        private String id;

        public java_29411_SessionManager_A08(String id) {
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