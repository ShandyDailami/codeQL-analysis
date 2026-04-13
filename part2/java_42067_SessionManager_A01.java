import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_42067_SessionManager_A01 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            // Load configuration and instantiate session factory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // Perform operations on the session

        session.close();
    }
}