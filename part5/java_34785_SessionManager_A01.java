import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_34785_SessionManager_A01 {

    public static void main(String[] args) {

        // Create session factory with Hibernate configuration
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Perform a Hibernate operation
        session.beginTransaction();

        // Assume we have a User entity with a name field
        User user = new User();
        user.setName("John Doe");

        // Persist the User
        session.save(user);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();

        // Shutdown factory
        factory.close();
    }
}