import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_27155_SessionManager_A01 {

    private SessionFactory sessionFactory;

    public java_27155_SessionManager_A01() {
        // load the Hibernate configuration file and instantiate a SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        // open a new session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // close a session
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session = sessionManager.getSession();

        // perform some operations...

        sessionManager.closeSession(session);
    }
}