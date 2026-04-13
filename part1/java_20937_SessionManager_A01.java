import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_20937_SessionManager_A01 {
    public static void main(String[] args) {
        // Load the Hibernate configuration
        Configuration configuration = new Configuration().configure();

        // Create the SessionFactory from the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a new Session
        Session session = sessionFactory.openSession();

        // Start a transaction
        session.beginTransaction();

        // Perform a database operation
        session.save(new Entity("A01_BrokenAccessControl"));

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}