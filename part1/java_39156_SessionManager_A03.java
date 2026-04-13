import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_39156_SessionManager_A03 {

    // Define the session factory
    private static SessionFactory sessionFactory;

    // Method to initialize the session factory
    public static void init() {
        try {
            // Create the configuration object
            Configuration configuration = new Configuration();

            // Configure Hibernate
            configuration.configure("hibernate.cfg.xml");

            // Create the session factory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to get a session
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Main method
    public static void main(String[] args) {
        // Initialize the session factory
        init();

        // Get a session
        Session session = getSession();

        // Use the session (e.g., session.save(...))
        session.save(new Entity("Hello"));

        // Close the session
        session.close();
    }
}