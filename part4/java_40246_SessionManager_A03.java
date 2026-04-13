import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_40246_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                ex.printStackTrace();
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();

        // Perform your operations here

        session.getTransaction().commit();
        session.close();
    }
}