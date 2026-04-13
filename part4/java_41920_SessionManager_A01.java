import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_41920_SessionManager_A01 {

    private static SessionFactory sessionFactory;  

    // Create the session factory with the configuration file
    public static SessionFactory getSessionFactory() {
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

    // Open a session
    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    // Close the session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Perform a transactional operation
    public static void performTransactionalOperation(Session session) {
        session.beginTransaction();
        // Perform your operations here
        session.getTransaction().commit();
    }
}