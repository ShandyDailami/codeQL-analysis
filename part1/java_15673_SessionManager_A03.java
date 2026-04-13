public class java_15673_SessionManager_A03 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    // Private constructor to enforce the use of getInstance() method
    private java_15673_SessionManager_A03() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
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

    public void closeSessionFactory() {
        sessionFactory.close();
    }
}