public class java_07490_SessionManager_A08 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_07490_SessionManager_A08() {
        // Load configuration and set up session factory
        // This part is not necessary for the example, it's only to initialize a sessionFactory
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}