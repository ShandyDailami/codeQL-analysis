public class java_21995_SessionManager_A01 {
    private static SessionManager sessionManager = null;
    private SessionFactory sessionFactory = null;

    private java_21995_SessionManager_A01() {
        // load the configuration from xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // create the session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionManager getSessionManager() {
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