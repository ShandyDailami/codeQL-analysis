public class java_33368_SessionManager_A01 {

    // Private static instance of the SessionManager
    private static SessionManager sessionManager = null;

    // Private SessionFactory instance
    private SessionFactory sessionFactory = null;

    // Private Session instance
    private Session session = null;

    // Private constructor to prevent instantiation
    private java_33368_SessionManager_A01() {
        initializeSessionFactory();
        openSession();
    }

    // Public method to get the instance of the SessionManager
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Private method to initialize the SessionFactory
    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    // Private method to open a session
    private void openSession() {
        session = sessionFactory.openSession();
    }

    // Public method to get the session
    public Session getSession() {
        return session;
    }

    // Public method to close the session
    public void closeSession() {
        session.close();
    }
}