import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_11119_SessionManager_A08 {
    public static void main(String[] args) {
        // Load the Hibernate configuration
        Configuration configuration = new Configuration().configure();

        // Create the session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Perform integrity failure operation here
        // Example: trying to delete a row that doesn't exist
        session.delete(session.get(ExampleEntity.class, 9999));

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();
    }
}