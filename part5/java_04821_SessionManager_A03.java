import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_04821_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();

        // Start a transaction
        session.beginTransaction();

        // Perform operations...

        // Commit the transaction
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}