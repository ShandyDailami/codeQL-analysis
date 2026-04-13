import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_21125_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Load the Hibernate configuration file
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Create the session factory
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

        // start a transaction
        session.beginTransaction();

        // Use the session object as you would with any other DAO object

        // commit the transaction
        session.getTransaction().commit();
        session.close();
    }
}