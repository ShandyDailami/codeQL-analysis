public class java_02051_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_02051_SessionManager_A01() {
        initialize();
    }

    private void initialize() {
        Configuration configuration = new Configuration();
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory();
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

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }
}