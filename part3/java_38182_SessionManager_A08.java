import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_38182_SessionManager_A08 {

    private static SessionFactory sessionFactory;

    private java_38182_SessionManager_A08() {}

    public static SessionFactory getSessionFactory() {
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

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        session.beginTransaction();

        // Here you could insert, update, delete or query the database

        session.getTransaction().commit();
        session.close();
    }
}