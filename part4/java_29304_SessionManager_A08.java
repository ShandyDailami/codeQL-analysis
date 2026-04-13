import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_29304_SessionManager_A08 {
    public static void main(String[] args) {
        // Create the session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Use the session object to perform CRUD operations (e.g., save, update, delete, etc.)
        // ...

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        // Close the session factory
        sessionFactory.close();
    }
}