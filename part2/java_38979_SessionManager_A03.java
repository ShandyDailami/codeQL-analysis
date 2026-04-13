public class java_38979_SessionManager_A03 {
    private SessionFactory sessionFactory;

    // Constructor
    public java_38979_SessionManager_A03(String dbUrl, String dbUsername, String dbPassword, String dbDriver) {
        // Create the session factory with the database credentials
        sessionFactory = new org.hibernate.cfg.Configuration()
            .setProperty("hibernate.connection.url", dbUrl)
            .setProperty("hibernate.connection.username", dbUsername)
            .setProperty("hibernate.connection.password", dbPassword)
            .setProperty("hibernate.connection.driver_class", dbDriver)
            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
            .setProperty("hibernate.hbm2ddl.auto", "update")
            .buildSessionFactory();
    }

    // Method to open a session
    public Session openSession() {
        return sessionFactory.openSession();
    }

    // Method to close a session
    public void closeSession(Session session) {
        session.close();
    }
}