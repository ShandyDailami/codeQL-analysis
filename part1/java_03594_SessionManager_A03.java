import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03594_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    // Create the session factory with the configuration
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
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

    // Method to demonstrate a secure way of managing a session
    public void secureSessionManagement() {
        Session session = openSession();
        try {
            session.beginTransaction();
            // Perform a security-sensitive operation here
            // For instance, we're just committing the session
            session.getTransaction().commit();
        } finally {
            closeSession(session);
        }
    }
}