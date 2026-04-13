import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_10211_SessionManager_A08 {
    private final SessionFactory sessionFactory;

    public java_10211_SessionManager_A08() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        DatabaseSessionManager sessionManager = new DatabaseSessionManager();
        Session session = sessionManager.getSession();

        // Perform integrity-sensitive operations here.

        sessionManager.closeSession(session);
    }
}