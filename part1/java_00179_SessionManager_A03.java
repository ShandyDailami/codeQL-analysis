import java.util.HashMap;
import java.util.Map;

public class java_00179_SessionManager_A03 {
    private Map<String, Session> sessions = new HashMap<>();
    private SessionFactory sessionFactory;

    public java_00179_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(String name) {
        Session session = sessions.get(name);
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.put(name, session);
        }
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session.getSessionIdentifier());
        session.close();
    }

    public void closeAllSessions() {
        for (Map.Entry<String, Session> entry : sessions.entrySet()) {
            Session session = entry.getValue();
            session.close();
        }
        sessions.clear();
    }
}