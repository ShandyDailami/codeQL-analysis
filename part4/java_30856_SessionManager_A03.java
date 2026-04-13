public class java_30856_SessionManager_A03 {
    private static SessionManager instance = null;
    private Session session = null;

    private java_30856_SessionManager_A03() {
        // Use a standard library for creating a SessionFactory
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return this.session;
    }
}