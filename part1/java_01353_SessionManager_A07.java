import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_01353_SessionManager_A07 {
    public static void main(String[] args) {
        // Create the session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open a new session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Perform some operations...

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}