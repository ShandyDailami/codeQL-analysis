import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_31460_SessionManager_A07 {

    // Create the session factory with the Hibernate configuration
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the Hibernate configuration file
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Create the session factory from the configuration
            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the current session
    public static Session currentSession() {
        return sessionFactory.openSession();
    }

    // Closes the SessionFactory
    public static void shutdown() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        Session session = currentSession();
        // Perform operations with the session
        // ...

        // Close the session factory
        shutdown();
    }
}