import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02446_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            initializeSessionFactory();
        }
        return sessionFactory.openSession();
    }

    private static void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        Session session = getSession();
        // perform security-sensitive operations here
        closeSession(session);
    }
}