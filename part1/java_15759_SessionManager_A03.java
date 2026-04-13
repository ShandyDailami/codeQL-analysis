import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_15759_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    private java_15759_SessionManager_A03() {
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            initializeSessionFactory();
        }
        return sessionFactory.openSession();
    }

    private static void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // do something with session here
    }
}