import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_06633_SessionManager_A08 {

    public static void main(String[] args) {
        // Create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open a new session
        Session session = factory.openSession();

        try {
            // Create a User object
            User user = new User();
            user.setName("Test User");

            // Begin a transaction
            session.beginTransaction();

            // Save the user object
            session.save(user);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
       
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}

class User {
    private int id;
    private String name;

    // Getters and setters
    // ...
}