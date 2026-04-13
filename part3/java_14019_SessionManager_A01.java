import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_14019_SessionManager_A01 {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        configureSessionFactory();
        useSessionFactory();
    }

    private static void configureSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void useSessionFactory() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Here you should put the operation that needs security-sensitive
            // For example, updating a user's password
            User user = session.get(User.class, "user1");
            user.setPassword("newPassword");
            session.update(user);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static class User {
        private String id;
        private String password;

        // Getters and setters
    }
}