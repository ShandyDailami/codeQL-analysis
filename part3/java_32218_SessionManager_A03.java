import java.util.HashSet;
import java.util.Set;

public class java_32218_SessionManager_A03 {
    private final Set<Session> validSessions = new HashSet<>();
    private final SessionFactory sessionFactory;

    public java_32218_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        Session session = sessionFactory.openSession();
        validSessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        validSessions.remove(session);
        session.close();
    }

    public Session getSessionForUser(String username) {
        // TODO: Implement user authentication and return valid session
        // This is a placeholder.
        return null;
    }

    public boolean isValidSession(Session session) {
        return validSessions.contains(session);
    }
}