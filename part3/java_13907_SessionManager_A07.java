import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13907_SessionManager_A07 {
    public static void main(String[] args) {
        // Load the configuration and start the session
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        // Create and save a user
        session.beginTransaction();

        User user = new User("John", "Doe");
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}

// Define your User class here
class User {
    private String firstName;
    private String lastName;

    public java_13907_SessionManager_A07(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters here
}