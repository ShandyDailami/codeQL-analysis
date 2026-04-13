import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_08131_SessionManager_A01 {
    public static void main(String[] args) {
        // Load the Hibernate Configuration
        Configuration configuration = new Configuration().configure();
        
        // Create the SessionFactory from the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        // Create a new Session
        Session session = sessionFactory.openSession();
        
        // Start a transaction
        Transaction transaction = session.beginTransaction();
        
        // Perform some operations here
        
        // Commit the transaction
        transaction.commit();
        
        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}