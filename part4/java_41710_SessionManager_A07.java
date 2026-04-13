import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_41710_SessionManager_A07 {

    private static SessionManager sessionManager;
    private static SessionFactory sessionFactory;

    private java_41710_SessionManager_A07() {
        // Private constructor to prevent instantiation of this class
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}