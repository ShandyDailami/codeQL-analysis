public class java_03138_SessionManager_A07 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_03138_SessionManager_A07() {
        // Load the database configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Initialize the SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession(String userId) {
        Session session = null;

        // Create a session using the user's id and the session factory
        session = sessionFactory.openSession();

        // Perform a select query
        session.beginTransaction();
        User user = session.get(User.class, userId);
        session.getTransaction().commit();

        return session;
    }
}