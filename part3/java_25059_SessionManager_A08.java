import java.sql.Session;
import java.sql.SQLException;

public class java_25059_SessionManager_A08 {

    private java.sql.SessionFactory sessionFactory;

    public java_25059_SessionManager_A08(java.sql.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        return this.sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void doTransactionalOperation(Runnable transaction) {
        Session session = null;
        try {
            session = openSession();
            session.beginTransaction();
            transaction.run();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            closeSession(session);
        }
    }

    public static void main(String[] args) {
        // initialize the session factory here
        // SessionManager sessionManager = new SessionManager(sessionFactory);

        // example transactional operation
        SessionManager sessionManager = new SessionManager(null);
        sessionManager.doTransactionalOperation(() -> {
            // write your code here
        });
    }
}