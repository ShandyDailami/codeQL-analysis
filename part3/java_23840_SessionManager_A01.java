public class java_23840_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_23840_SessionManager_A01() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}