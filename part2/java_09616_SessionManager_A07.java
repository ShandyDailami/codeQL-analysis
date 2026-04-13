import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09616_SessionManager_A07 {
    private static SessionFactory sessionFactory;  

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = getSession();
        // Use session to perform operations here
        session.beginTransaction();
        // ...
        session.getTransaction().commit();
        session.close();
    }
}