public class java_30489_SessionManager_A03 {
    private static SessionManager sessionManager;
    private Session session;

    private java_30489_SessionManager_A03() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void rollbackTransaction() {
        session.getTransaction().rollback();
    }

    public Object findById(Class clazz, Serializable id) {
        return session.get(clazz, id);
    }

    public void saveOrUpdate(Object object) {
        session.saveOrUpdate(object);
        session.flush();
    }

    public void delete(Object object) {
        session.delete(object);
        session.flush();
    }
}