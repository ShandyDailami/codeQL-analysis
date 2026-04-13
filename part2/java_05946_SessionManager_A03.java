import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_05946_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        Session session = getSession();
        // Use the session to perform operations...
    }
}