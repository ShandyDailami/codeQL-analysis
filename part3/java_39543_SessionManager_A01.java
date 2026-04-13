public class java_39543_SessionManager_A01 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;
    private Session currentSession;

    private java_39543_SessionManager_A01() {
        // Initialize sessionFactory
        sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getCurrentSession() {
        if (currentSession == null) {
            currentSession = sessionFactory.openSession();
        }
        return currentSession;
    }

    public void closeCurrentSession() {
        if (currentSession != null) {
            currentSession.close();
            currentSession = null;
        }
    }
}