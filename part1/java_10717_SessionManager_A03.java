public class java_10717_SessionManager_A03 {

    // Singleton pattern for session management
    private static SessionManager sessionManager;
    private Session session;

    private java_10717_SessionManager_A03() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
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

    public void save(Object obj) {
        session.save(obj);
    }

    public void update(Object obj) {
        session.update(obj);
    }

    public void delete(Object obj) {
        session.delete(obj);
    }

    public void query(String queryStr) {
        Query query = session.createQuery(queryStr);
        query.list().forEach(System.out::println);
    }
}