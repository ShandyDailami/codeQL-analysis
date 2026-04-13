import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_05573_SessionManager_A08 {
    private static SessionFactory sessionFactory;

    // Load the Hibernate configuration file and instantiate a session factory
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the current session
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // Close the session factory
    public static void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // start a new transaction
        session.beginTransaction();

        // perform operations

        // commit the transaction
        session.getTransaction().commit();

        // now the session factory is closed
        close();
    }
}