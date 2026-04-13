import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_20844_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    // Load the Hibernate Configuration
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get Session from the SessionFactory
    public static Session getSession() throws Exception {
        Session session = sessionFactory.openSession();
        if (session == null) {
            throw new Exception("Could not open session");
        }
        return session;
    }

    public static void main(String[] args) throws Exception {
        Session session = getSession();
        session.beginTransaction();
        // perform your operations here
        session.getTransaction().commit();
    }
}