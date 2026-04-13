import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_35090_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    // Load the Hibernate configuration
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // Perform operations on the session
        session.beginTransaction();
        // Example: save an object
        session.save(new User("username", "password"));
        session.getTransaction().commit();
        session.close();
    }
}