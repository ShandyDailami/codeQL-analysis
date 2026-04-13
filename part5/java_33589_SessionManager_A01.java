import java.util.HashSet;
import java.util.Set;

public class java_33589_SessionManager_A01 {
    private Set<Session> sessions;
    private static int sessionIdCounter = 1;

    public java_33589_SessionManager_A01() {
        sessions = new HashSet<>();
    }

    public Session createSession() {
        Session session = new Session(sessionIdCounter++);
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public Session getSession(int sessionId) {
        for (Session session : sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        return null; // Session not found
    }

    public static class Session {
        private int id;

        public java_33589_SessionManager_A01(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}