public class java_07749_SessionManager_A08 {
    private static SecureSessionManager instance;
    private boolean isSecure;
    private SessionFactory sessionFactory;

    private java_07749_SessionManager_A08(String dbUrl, String user, String password, boolean isSecure) {
        this.isSecure = isSecure;
        this.sessionFactory = createSessionFactory(dbUrl, user, password);
    }

    private static SecureSessionManager getInstance(String dbUrl, String user, String password, boolean isSecure) {
        if (instance == null) {
            instance = new SecureSessionManager(dbUrl, user, password, isSecure);
        }
        return instance;
    }

    private SessionFactory createSessionFactory(String dbUrl, String user, String password) {
        String driver = "com.mysql.jdbc.Driver";
        String url = dbUrl;
        String username = user;
        String passwordDB = password;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new org.hibernate.cfg.Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", driver)
                .setProperty("hibernate.connection.url", url)
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", passwordDB)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(Entity.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void main(String[] args) {
        try {
            SecureSessionManager manager = getInstance("jdbc:mysql://localhost:3306/test", "root", "root", true);
            Session session = manager.openSession();
            session.beginTransaction();
            // perform security-sensitive operations here
            // for example, store sensitive data in a database
            session.getTransaction().commit();
            manager.closeSession(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}