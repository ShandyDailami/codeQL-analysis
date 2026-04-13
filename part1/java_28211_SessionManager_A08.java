public class java_28211_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;

    private java_28211_SessionManager_A08() {
        // Create a session for the database connection
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistry();
        serviceRegistry.applySettings(configuration.getProperties());
        session = configuration.buildSessionFactory(serviceRegistry).openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }
}