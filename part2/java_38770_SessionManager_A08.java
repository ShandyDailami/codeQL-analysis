import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class java_38770_SessionManager_A08 {
    @Id
    private String username;
    private String password;

    // Constructors, getters, and setters omitted for brevity
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        // Create a new User object
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");

        // Open a new session
        Session session = getSessionFactory().openSession();

        // Begin the transaction
        session.beginTransaction();

        // Save the user
        session.save(user);

        // Commit the transaction
        session.getTransaction().commit();
        session.close();

        // Retrieve the user
        session = getSessionFactory().openSession();
        user = session.get(User.class, user.getUsername());
        System.out.println("Retrieved user: " + user);
        session.close();
    }
}