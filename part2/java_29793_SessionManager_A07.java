// Imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_29793_SessionManager_A07 {
    // Instance of SessionFactory
    private static SessionFactory sessionFactory;

    // Initialize the SessionFactory
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to open a session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // Method to close a session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Method to commit a transaction
    public static void commitSession(Session session) {
        if (session != null) {
            session.getTransaction().commit();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Session session = openSession();
        // Perform operations on the session
        closeSession(session);
    }
}