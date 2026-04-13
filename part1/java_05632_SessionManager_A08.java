import java.util.ArrayList;
import java.util.List;

public class java_05632_SessionManager_A08 {
    private List<Session> sessions;
    private static int sessionCount = 0;

    public java_05632_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public Session openSession() {
        Session session = new Session();
        session.setId(++sessionCount);
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session1 = sessionManager.openSession();
        Session session2 = sessionManager.openSession();
        sessionManager.closeSession(session1);
        sessionManager.closeSession(session2);
    }

    private class Session {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}