public class java_10288_SessionManager_A01 {

    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_10288_SessionManager_A01() {
        initialize();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initialize() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}