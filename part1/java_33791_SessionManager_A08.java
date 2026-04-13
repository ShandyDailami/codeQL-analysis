import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_33791_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            // Load the Hibernate configuration file
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            // Create the SessionFactory from the configuration
            sessionFactory = configuration.buildSessionFactory();
        }

        // Open a new session
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Get a session
        Session session = getSession();

        // Start a transaction
        session.beginTransaction();

        // TODO: Perform integrity-sensitive operations related to A08_IntegrityFailure

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}