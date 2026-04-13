public class java_39707_SessionManager_A03 {

    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_39707_SessionManager_A03() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
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