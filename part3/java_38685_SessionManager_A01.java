public class java_38685_SessionManager_A01 {

    private static SessionManager instance;
    private Session session;

    private java_38685_SessionManager_A01() {
        // use this to open a session
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new ServiceRegistry();
        serviceRegistry.applySettings(configuration.getProperties());

        this.session = configuration.buildSessionFactory(serviceRegistry).openSession();
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

    public void closeSession() {
        session.close();
    }
}