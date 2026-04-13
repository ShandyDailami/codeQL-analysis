import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_27118_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Load the configuration file
        Configuration configuration = new Configuration();
        configuration.configure();

        // Build the session factory
        sessionFactory = configuration.buildSessionFactory();

        // Open a new session
        Session session = getSession();

        // Start a transaction
        session.beginTransaction();

        // Perform database operations here...

        // Commit the transaction
        session.getTransaction().commit();
        session.close();
    }
}