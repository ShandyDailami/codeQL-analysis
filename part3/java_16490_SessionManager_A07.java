import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_16490_SessionManager_A07 {
    private static SessionFactory sessionFactory;  

    // Create the session factory
    static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    // Begins session using the Hibernate SessionFactory
    public Session beginSession() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory.openSession();
    }

    // Closes the session factory and the session
    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
        sessionFactory.close();
    }

    // Generic method to perform operations
    public void performOperations(Session session) {
        // Insert code here
    }

    // Main method
    public static void main(String[] args) {
        HibernateSessionManager sessionManager = new HibernateSessionManager();
        Session session = sessionManager.beginSession();
        try {
            sessionManager.performOperations(session);
        }
        finally {
            sessionManager.closeSession(session);
        }
    }
}