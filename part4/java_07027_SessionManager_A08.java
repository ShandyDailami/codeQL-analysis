import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_07027_SessionManager_A08 {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        // Use session to perform operations
        // Here, we're just printing out the session id
        System.out.println("Session ID: " + session.getSession().getId());

        // Close session
        session.close();
    }
}