public class java_07916_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_07916_SessionManager_A01() {
        // Create a new session
        SessionConfiguration configuration = new SessionConfiguration();
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/test");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");

        configuration.configure();

        // Create a new session
        this.session = configuration.buildSessionFactory().openSession();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    public Session getSession() {
        return session;
    }
}