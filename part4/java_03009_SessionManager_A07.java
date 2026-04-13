import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03009_SessionManager_A07 {
    private static SessionFactory sessionFactory;   // SessionFactory is the responsibility of Hibernate

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Create the session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}