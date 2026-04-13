public class java_00039_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_00039_SessionManager_A01() {
        // Create sessionFactory
        Configuration configuration = new Configuration();
        configuration.configure();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
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