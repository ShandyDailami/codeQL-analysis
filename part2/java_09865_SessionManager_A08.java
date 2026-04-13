public class java_09865_SessionManager_A08 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_09865_SessionManager_A08() {
        initialize();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    private void initialize() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}