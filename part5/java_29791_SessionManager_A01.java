import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_29791_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Initialize session factory
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        // Use session to interact with your data
        Session session = getSession();
        // perform operations on the session here

        // Close the session
        session.close();
    }
}