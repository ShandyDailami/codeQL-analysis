import java.util.HashMap;

public class java_35403_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_35403_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session openSession() {
        String id = "session" + System.currentTimeMillis();
        Session session = new Session(id);
        sessions.put(id, session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void closeSession(String id) {
        sessions.remove(id);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.openSession();
        Session session2 = sessionManager.openSession();

        // get session
        Session getSession = sessionManager.getSession(session1.getId());

        // close session
        sessionManager.closeSession(session1.getId());
    }
}