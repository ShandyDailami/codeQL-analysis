import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_28035_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    // Load the Hibernate configuration file and create a session factory
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get a session from the session factory
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // perform some operation using the session
        session.beginTransaction();
        // example operation
        session.save(new User("John", "Doe"));
        session.getTransaction().commit();
        session.close();
    }

    // User entity
    static class User {
        private String firstName;
        private String lastName;

        public java_28035_SessionManager_A08(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // getters and setters
    }
}