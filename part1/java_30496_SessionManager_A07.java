import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_30496_SessionManager_A07 {

    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        if (session != null) {
            System.out.println("Session was opened");
        } else {
            System.out.println("Session was not opened");
        }
    }
}