import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02815_SessionManager_A01 {

    public static void main(String[] args) {
        // Create the session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create a new session
        Session session = sessionFactory.openSession();

        // Perform some operations...

        // Close the session
        session.close();
    }
}