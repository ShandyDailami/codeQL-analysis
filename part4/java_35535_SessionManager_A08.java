import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_35535_SessionManager_A08 {

    private SessionFactory sessionFactory;

    public java_35535_SessionManager_A08() {
        // Load the Hibernate configuration
        Configuration configuration = new Configuration().configure();
        // Create a session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        // Get a session from the session factory
        Session session = sessionFactory.openSession();

        // Start a transaction
        session.beginTransaction();

        // Make sure the session is secure
        session.evict(session);

        return session;
    }

    public void closeSession(Session session) {
        // If the session is not null and has not been closed yet, close it
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}