import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_33304_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    // Static initializer for SessionFactory
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to get a session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to close a session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Method to commit a session
    public static void commit(Session session) {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    // Method to rollback a session
    public static void rollback(Session session) {
        if (session != null) {
            session.getTransaction().rollback();
        }
    }
}