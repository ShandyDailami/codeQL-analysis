public class java_23763_SessionManager_A01 {

    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_23763_SessionManager_A01(String connectionUrl, String username, String password) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.setProperty("hibernate.connection.url", connectionUrl);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(configuration.getProperties());
        StandardServiceRegistry registry = registryBuilder.build();

        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public static SessionManager getInstance(String connectionUrl, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(connectionUrl, username, password);
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}