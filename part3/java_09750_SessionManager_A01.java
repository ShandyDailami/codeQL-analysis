import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09750_SessionManager_A01 {
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
        try {
            session.beginTransaction();

            // Insertion code here

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error occurred: " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}