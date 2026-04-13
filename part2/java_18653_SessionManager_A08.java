public class java_18653_SessionManager_A08 {
    private static SessionManager sessionManager;
    private Session session;

    private java_18653_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession(new Configuration()
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "password")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.current_session_context_class", "org.hibernate.ctx.ThreadContextSessionSource")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Role.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession() {
        return this.session;
    }
}