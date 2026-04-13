public class java_40146_SessionManager_A03 {

    // Define a private instance of SessionFactory
    private SessionFactory sessionFactory;

    // The constructor for SessionManager requires a SessionFactory
    public java_40146_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // The session method will open a session and return it
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // The transaction method will open a transactional session and return it
    public Transaction beginTransaction() {
        return sessionFactory.getCurrentSession().beginTransaction();
    }

    // The commit method will commit the transaction
    public void commit(Transaction transaction) {
        transaction.commit();
    }

    // The rollback method will rollback the transaction
    public void rollback(Transaction transaction) {
        transaction.rollback();
    }

    // The close method will close the session
    public void close(Session session) {
        session.close();
    }
}