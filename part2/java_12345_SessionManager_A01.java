import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_12345_SessionManager_A01 {

    public static void main(String[] args) {

        // Load the hibernate configuration file and create a session factory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Start a transaction
        session.beginTransaction();

        // Create a User object and store it in the session
        User user = new User("username", "password");
        session.save(user);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}

class User {
    private String username;
    private String password;

    public java_12345_SessionManager_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters...
}