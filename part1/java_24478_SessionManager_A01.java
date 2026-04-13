public class java_24478_SessionManager_A01 {
    // The session factory
    private SessionFactory sessionFactory;

    // Constructor
    public java_24478_SessionManager_A01(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Open a session
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // Begin a transaction
    public Transaction beginTransaction() {
        return openSession().beginTransaction();
    }

    // Commit a transaction
    public void commitTransaction(Transaction transaction) {
        transaction.commit();
    }

    // Close a session
    public void closeSession(Session session) {
        session.close();
    }

    // Rollback a transaction
    public void rollbackTransaction(Transaction transaction) {
        transaction.rollback();
    }
}