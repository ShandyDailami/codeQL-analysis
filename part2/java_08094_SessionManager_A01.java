import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_08094_SessionManager_A01 {
    private SessionFactory sessionFactory;

    public java_08094_SessionManager_A01() {
        // Load configuration and build SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        // Get a session from the SessionFactory
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Close a session
        if (session != null) {
            session.close();
        }
    }
}