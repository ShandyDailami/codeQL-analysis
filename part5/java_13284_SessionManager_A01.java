import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13284_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    // Create a SessionFactory
    static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    // Open a Session
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // Close the SessionFactory
    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {

        // Build a SessionFactory
        sessionFactory = buildSessionFactory();

        // Open a Session
        Session session = openSession();

        // Use the session
        // ...

        // Close the SessionFactory
        close();
    }
}