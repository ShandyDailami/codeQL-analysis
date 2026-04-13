public class java_41852_SessionManager_A08 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    // Private constructor to restrict instantiation
    private java_41852_SessionManager_A08() {
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

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}