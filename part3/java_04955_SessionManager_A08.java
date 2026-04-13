public class java_04955_SessionManager_A08 {

    private static SessionManager sessionManager;
    private Session session;

    private java_04955_SessionManager_A08() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void startTransaction() {
        session.beginTransaction();
    }

    public void commit() {
        session.getTransaction().commit();
        session.close();
    }

    public void rollback() {
        session.getTransaction().rollback();
        session.close();
    }

    public void save(Object object) {
        session.save(object);
        session.getTransaction().commit();
    }

    public void update(Object object) {
        session.update(object);
        session.getTransaction().commit();
    }

    public void delete(Object object) {
        session.delete(object);
        session.getTransaction().commit();
    }
}