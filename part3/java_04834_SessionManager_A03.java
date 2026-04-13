public class java_04834_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_04834_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }

    public void beginTransaction(Session session) {
        session.beginTransaction();
    }

    public void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

    public void rollbackTransaction(Session session) {
        session.getTransaction().rollback();
    }
}