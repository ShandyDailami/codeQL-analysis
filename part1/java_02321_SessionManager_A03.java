import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_02321_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    public static Session openSession() {
        if (sessionFactory == null) {
            initializeSessionFactory();
        }

        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    private static void initializeSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session = openSession();

        // Perform operations on session...

        closeSession(session);
    }
}