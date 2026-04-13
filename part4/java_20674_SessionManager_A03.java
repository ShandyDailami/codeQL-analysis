public class java_20674_SessionManager_A03 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_20674_SessionManager_A03() {
        Configuration configuration = new Configuration();
        configuration.configure(); // load configuration file

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        StandardServiceRegistry registry = builder.build();

        sessionFactory = configuration.buildSessionFactory(registry);
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