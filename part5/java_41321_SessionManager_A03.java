public class java_41321_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_41321_SessionManager_A03(String driver, String url, String username, String password) {
        try {
            // Load driver.
            Class.forName(driver);

            // Create session factory.
            sessionFactory = new org.hibernate.cfg.Configuration()
                    .setDriver(Class.forName(driver))
                    .setURL(url)
                    .setUsername(username)
                    .setPassword(password)
                    .configure()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public static void main(String[] args) {
        // Create SessionManager using Hibernate's session factory.
        SessionManager sessionManager = new SessionManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "username", "password");

        // Use session.
        Session session = sessionManager.getSession();
        session.beginTransaction();

        // Perform some operations.
        session.save(new User("John", "Doe"));
        session.getTransaction().commit();

        sessionManager.closeSession(session);
    }

}