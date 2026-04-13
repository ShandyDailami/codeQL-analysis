import java.util.ArrayList;

public class java_40077_SessionManager_A08 {
    private ArrayList<Session> sessions;

    public java_40077_SessionManager_A08() {
        sessions = new ArrayList<>();
    }

    public Session getSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public static class Session {
        // This is a placeholder for a session
    }
}