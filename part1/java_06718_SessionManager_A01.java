public class java_06718_SessionManager_A01 {

    private static SessionManager instance;
    private SessionFactory sessionFactory;

    // Private constructor to prevent instantiation of this class
    private java_06718_SessionManager_A01() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // Static method to get the single instance of this class
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