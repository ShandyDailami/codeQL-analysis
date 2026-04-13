import java.util.LinkedList;

public class java_35035_SessionManager_A08 {
    private LinkedList<Session> sessions;

    public java_35035_SessionManager_A08() {
        this.sessions = new LinkedList<>();
    }

    public Session createSession() {
        Session session = new Session();
        this.sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        this.sessions.remove(session);
    }

    public void checkSessionIntegrity() {
        for (Session session : this.sessions) {
            if (!session.isValid()) {
                closeSession(session);
            }
        }
    }

    public static class Session {
        private boolean valid;

        public java_35035_SessionManager_A08() {
            this.valid = true; // A session is initially valid.
        }

        public boolean isValid() {
            return this.valid;
        }

        public void invalidate() {
            this.valid = false; // Invalidate the session.
        }
    }
}