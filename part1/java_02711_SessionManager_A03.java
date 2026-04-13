import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02711_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the Hibernate configuration file
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Create the session factory from the configuration
            sessionFactory = configuration.buildSessionFactory();
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
        // use the session to perform operations
    }
}