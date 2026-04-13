import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_08819_SessionManager_A08 {
    private static SessionFactory sessionFactory;   // SessionFactory is in-memory, single-threaded
    private static Session session;

    // Create the sessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    // Open the session
    public static Session openSession() {
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    // Close the session
    public static void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    // Main method
    public static void main(String[] args) {
        Session session = openSession();
        // Perform your operations here
        closeSession();
    }
}