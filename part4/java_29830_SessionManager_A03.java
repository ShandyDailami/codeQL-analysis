import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_29830_SessionManager_A03 {

    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        try {
            session.beginTransaction();
            // Your code here...
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}