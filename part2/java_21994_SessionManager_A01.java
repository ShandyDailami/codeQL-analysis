public class java_21994_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_21994_SessionManager_A01() {
        // Create a configuration object and initialize it with HikariCP settings
        Configuration configuration = new Configuration();
        configuration.setDriverClassName("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://localhost/test?useSSL=false");
        configuration.setUsername("root");
        configuration.setPassword("password");

        // Initialize the SessionFactory
        sessionFactory = configuration.configure("org/hibernate/mapping/hbm2ddl/").buildSessionFactory();
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