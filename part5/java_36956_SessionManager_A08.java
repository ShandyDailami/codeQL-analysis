import java.util.LinkedList;

public class java_36956_SessionManager_A08 {
    private LinkedList<Session> sessions;

    public java_36956_SessionManager_A08() {
        sessions = new LinkedList<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public static class Session {
        private boolean isActive;

        public java_36956_SessionManager_A08() {
            isActive = true;
        }

        public void close() {
            isActive = false;
        }

        public boolean isActive() {
            return isActive;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        Session session1 = manager.createSession();
        Session session2 = manager.createSession();
        Session session3 = manager.createSession();

        session1.close(); // This should remove the session from the manager

        System.out.println(session2.isActive()); // Outputs: true
        System.out.println(session3.isActive()); // Outputs: true
    }
}