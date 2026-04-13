public class java_36347_SessionManager_A07 {
    private static SessionManager sessionManager;
    private Session session;

    private java_36347_SessionManager_A07() {
        // use the factory below to create a SessionFactory with the settings
        Configuration configuration = new Configuration();
        configuration.configure();

        // create a new session
        session = configuration.buildSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void beginTransaction() {
        session.beginTransaction();
    }

    public void commitTransaction() {
        session.getTransaction().commit();
    }

    public void save(Object object) {
        session.save(object);
    }

    public void update(Object object) {
        session.update(object);
    }

    public void delete(Object object) {
        session.delete(object);
    }
}