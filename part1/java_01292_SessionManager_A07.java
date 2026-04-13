import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_01292_SessionManager_A07 {

    private static SessionManager sessionManager = null;
    private SessionFactory sessionFactory = null;

    private java_01292_SessionManager_A07() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (SessionException e) {
            System.out.println("Could not open session. " + e.getMessage());
        }
        return session;
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}