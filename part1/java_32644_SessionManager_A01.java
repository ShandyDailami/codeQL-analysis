import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_32644_SessionManager_A01 {
    private static SessionFactory sessionFactory;

    // Initialize session factory
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Private constructor to prevent instantiation
    private java_32644_SessionManager_A01() {
        throw new UnsupportedOperationException();
    }

    // Open a session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // Close the session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Return the session factory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}