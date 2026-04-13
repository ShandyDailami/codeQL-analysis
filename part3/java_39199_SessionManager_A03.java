import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_39199_SessionManager_A03 {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Perform security-sensitive operation here.
            // This is a demonstration, actual use cases may require more complex operations.
            String query = "FROM User WHERE username = :username";
            User user = session.createQuery(query, User.class).setParameter("username", "admin").uniqueResult();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}