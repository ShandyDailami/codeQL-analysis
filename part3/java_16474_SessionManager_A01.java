public class java_16474_SessionManager_A01 {
    private static SessionManager instance;
    private SessionFactory sessionFactory;

    private java_16474_SessionManager_A01() {
        // Here you can use the javax.persistence library for creating the session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
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