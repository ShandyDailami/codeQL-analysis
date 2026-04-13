import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13903_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the configuration file and create a session factory
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        try {
            // Start your security-sensitive operations here

            session.beginTransaction();

            // ...

            session.getTransaction().commit();
            session.close();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}