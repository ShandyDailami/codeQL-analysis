public class java_02184_SessionManager_A01 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    // Private constructor to restrict new instances
    private java_02184_SessionManager_A01() {
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
}