public class java_32070_SessionManager_A03 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_32070_SessionManager_A03() {
        initializeSessionFactory();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(configuration.getProperties());
        StandardServiceRegistry registry = registryBuilder.build();

        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }
}