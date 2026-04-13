import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_34819_SessionManager_A01 {
    private static SessionFactory sessionFactory;

    // Initialize the session factory with the Hibernate configuration file
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Private constructor to prevent instantiation of the class
    private java_34819_SessionManager_A01() {}

    // Method to get the current session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Method to close the current session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}