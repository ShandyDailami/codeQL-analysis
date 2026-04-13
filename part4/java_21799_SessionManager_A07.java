public class java_21799_SessionManager_A07 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_21799_SessionManager_A07() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
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
}