import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13670_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the configuration file and start the session factory
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws Exception {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) throws Exception {
        Session session = getSession();
        // perform your operations here
        session.close();
    }
}