import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_32529_SessionManager_A03 {
    private final SessionFactory sessionFactory;

    public java_32529_SessionManager_A03() {
        try {
            // Load the Hibernate configuration file.
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Create the SessionFactory.
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession(String username, String password) {
        // Authenticate and get a session.
        return sessionFactory.openSession(username, password);
    }
}