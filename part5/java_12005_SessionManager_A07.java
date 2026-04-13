import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_12005_SessionManager_A07 {
    private static SessionFactory sessionFactory;

    private java_12005_SessionManager_A07() {}

    public static Session openSession() {
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

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        Session session = openSession();
        session.beginTransaction();
        // Your code here
        session.getTransaction().commit();
        closeSession(session);
    }
}