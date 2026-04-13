public class java_08053_SessionManager_A08 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_08053_SessionManager_A08() {
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
        configuration.configure(); // Load the configuration file
        // Add security-sensitive operations here
        configuration.addAnnotatedClass(User.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(registry);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}