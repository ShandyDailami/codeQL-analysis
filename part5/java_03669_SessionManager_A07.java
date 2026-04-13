import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03669_SessionManager_A07 {

    private static SessionFactory sessionFactory;

    static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        // use the session object for your operations
        session.beginTransaction();
        //...
        session.getTransaction().commit();
        session.close();
    }
}