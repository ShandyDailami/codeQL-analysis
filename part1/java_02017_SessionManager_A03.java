import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02017_SessionManager_A03 {

    public static void main(String[] args) {
        // Step 1: Set up the configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Step 2: Set up the factory using the configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Step 3: Open a new session
        Session session = sessionFactory.openSession();

        // Step 4: Use the session to perform a security-sensitive operation (injecting into the database)
        // For this example, let's say we're injecting a user into the database
        User user = new User();
        user.setUsername("test");
        user.setPassword("password");
        session.save(user);

        // Step 5: Close the session
        session.close();
    }

}