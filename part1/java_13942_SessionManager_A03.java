import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_13942_SessionManager_A03 {

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

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        Session session = getSession();
        try {
            session.beginTransaction();
            // Your code here
            session.getTransaction().commit();
        } catch (SessionException e) {
            System.err.println("Transaction failed: " + e);
            session.getTransaction().rollback();
        } finally {
            closeSession(session);
        }
    }
}