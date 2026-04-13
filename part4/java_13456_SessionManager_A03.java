import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13456_SessionManager_A03 {
    private static SessionFactory sessionFactory;   // Factory for Session

    // Create SessionFactory
    public static SessionFactory createSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    // Open a Session
    public static Session openSession() {
        sessionFactory = createSessionFactory();
        return sessionFactory.openSession();
    }

    // Create and save a user
    public static void main(String[] args) {
        Session session = openSession();
        try {
            session.beginTransaction();

            // Create User object
            User user = new User();
            user.setName("John Doe");
            user.setEmail("john@example.com");

            // Save User object
            session.save(user);

            session.getTransaction().commit();
            System.out.println("User saved successfully");
        }
        finally {
            session.close();
        }
    }
}