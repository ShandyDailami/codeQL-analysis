import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_31350_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    // Load the session factory from the Hibernate configuration file
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the session from the session factory
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Close the session from the session factory
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // This is a test method to show how the session factory can be used.
    public static void main(String[] args) {
        Session session = getSession();
        // perform some operation
        closeSession(session);
    }
}