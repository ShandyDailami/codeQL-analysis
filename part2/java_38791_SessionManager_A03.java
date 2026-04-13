import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_38791_SessionManager_A03 {

    public static void main(String[] args) {
        // Load the configuration file
        Configuration configuration = new Configuration();
        configuration.configure();

        // Create the SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a new Session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Create a new User object
        User user = new User("John", "Doe", "john@example.com", "password123");

        // Save the User
        session.save(user);

        // Commit the transaction
        session.getTransaction().commit();
        session.close();
    }
}

class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public java_38791_SessionManager_A03(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; // This is a security-sensitive operation
    }

    // Getters and setters for the fields
    // ...
}