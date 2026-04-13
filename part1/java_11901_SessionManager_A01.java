import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_11901_SessionManager_A01 {
    public static void main(String[] args) {
        // Load the Hibernate configuration
        Configuration configuration = new Configuration().configure();

        // Create the SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();

        // Open a new transaction
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            // Perform security-sensitive operations
            // This is a placeholder, replace with your actual code
            session.save(new User("John", "Doe"));

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

class User {
    private String firstName;
    private String lastName;

    public java_11901_SessionManager_A01(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters here
}