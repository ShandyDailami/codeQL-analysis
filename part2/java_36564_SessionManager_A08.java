import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_36564_SessionManager_A08 {
    public static void main(String[] args) {
        // Load the Hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure();

        // Create a session factory using the configuration file
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Use the session to perform some operations
        // ...

        // Close the session
        session.close();
    }
}