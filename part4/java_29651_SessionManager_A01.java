import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_29651_SessionManager_A01 {
    public static void main(String[] args) {
        // Load the configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create a session factory using the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Use the session object...

        // Close the session
        session.close();
    }
}