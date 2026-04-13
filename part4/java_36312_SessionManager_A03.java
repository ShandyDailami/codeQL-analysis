import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_36312_SessionManager_A03 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_36312_SessionManager_A03() {
        configure();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    private void configure() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}