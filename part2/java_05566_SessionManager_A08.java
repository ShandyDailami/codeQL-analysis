public class java_05566_SessionManager_A08 {
    // The session is represented by a reference to a SessionFactory.
    private SessionFactory sessionFactory;

    // Constructor
    public java_05566_SessionManager_A08(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // This method opens a session.
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // This method commits a transaction.
    public void commit(Session session) {
        try {
            session.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    // This method closes a session.
    public void close(Session session) {
        session.close();
    }
}