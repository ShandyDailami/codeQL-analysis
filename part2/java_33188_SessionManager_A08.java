import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_33188_SessionManager_A08 {

    private static SessionFactory sessionFactory;

    // Initialize the session factory with the Hibernate configuration
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Open a session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    // Close the session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Save the session
    public static void saveSession(Session session) {
        try {
            session.beginTransaction();
            session.save();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    // Main method
    public static void main(String[] args) {
        Session session = openSession();
        saveSession(session);
        closeSession(session);
    }
}