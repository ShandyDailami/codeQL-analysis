import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03522_SessionManager_A03 {
    private static SessionFactory sessionFactory;   // SessionFactory is a tool that orchestrates Hibernate.

    private java_03522_SessionManager_A03() {
        // restrict instantiation
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {   // Double check
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
        try {
            session.beginTransaction();
            // add your code here
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}