import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class java_06318_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private java_06318_SessionManager_A03() {}

    public static Optional<Session> getSession() {
        return Optional.ofNullable(sessionFactory.openSession());
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.doSomethingSecure();
    }

    private void doSomethingSecure() {
        Session session = getSession().orElseThrow(() -> new RuntimeException("Could not open session"));
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Here is where you perform security-related operations

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}