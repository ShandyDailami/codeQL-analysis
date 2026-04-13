import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_33830_SessionManager_A03 {

    // Step 1: Create a SessionFactory
    private static SessionFactory sessionFactory;

    // Step 2: Create a Session
    public static Session getSession() {
        if (sessionFactory == null) {
            initializeSessionFactory();
        }
        return sessionFactory.openSession();
    }

    // Step 3: Initialize the SessionFactory
    private static void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    // Step 4: Close the SessionFactory
    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}