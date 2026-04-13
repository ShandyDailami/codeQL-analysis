import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_05816_SessionManager_A01 {

    // Create the configuration object
    private static Configuration configure() {
        return new Configuration().configure();
    }

    // Create a SessionFactory
    public static SessionFactory createSessionFactory() {
        return configure().buildSessionFactory();
    }

    public static void main(String[] args) {
        // Create a session factory
        SessionFactory sessionFactory = createSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Create a transaction
        Transaction tx = session.beginTransaction();

        // Here goes your security-sensitive operation
        // For example, let's say you want to create a new user

        // Assume that the user is created in a method named createUser
        // In this case, let's create a new user
        User user = new User("John", "Doe", "john@example.com");
        session.save(user);

        // Commit the transaction
        tx.commit();
        session.close();
    }
}