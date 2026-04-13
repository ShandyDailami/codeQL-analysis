public class java_34003_SessionManager_A03 {

    private static SessionManager instance;
    private Session session;

    private java_34003_SessionManager_A03() {
        // Create and configure the session
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
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