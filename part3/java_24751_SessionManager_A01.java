//import necessary libraries
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_24751_SessionManager_A01 {

    // Create the session factory with the Hibernate configuration
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();

        return sessionFactory;
    }

    // This method will open a session
    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    // This method will close the session
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // This method will commit the session
    public static void commit(Session session) {
        session.getTransaction().commit();
    }

    // This method will rollback the session
    public static void rollback(Session session) {
        session.getTransaction().rollback();
    }
}