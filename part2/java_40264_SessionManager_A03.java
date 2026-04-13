import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_40264_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    // Create the session factory with the configuration
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the current session
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}