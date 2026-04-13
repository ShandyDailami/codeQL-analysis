public class java_08218_SessionManager_A03 {
    private static SessionManager instance = null;
    private SessionFactory sessionFactory = null;

    // Private constructor to prevent instantiation
    private java_08218_SessionManager_A03() {
        initialize();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private void initialize() {
        // Create the session factory
        sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    }

    public Session openSession() {
        // Open a session
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        // Close a session
        if (session != null) {
            session.close();
        }
    }
}