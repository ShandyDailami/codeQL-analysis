import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_30555_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    // Establish a session factory
    static SessionFactory buildSessionFactory() {
        try {
            // Create the configuration
            Configuration configuration = new Configuration();
            configuration.configure();

            // Create the session factory from the configuration
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // Use the session object as needed
    }
}