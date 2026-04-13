public class java_21489_SessionManager_A01 {

    private static SessionManager instance;
    private Session currentSession;

    private java_21489_SessionManager_A01() {
        // Private constructor to restrict new instances
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        Session session = SessionFactory.getSessionFactory().openSession();
        if (session.isOpen()) {
            currentSession = session;
        }
        return currentSession;
    }

    public void closeSession() {
        if (currentSession != null) {
            currentSession.close();
            currentSession = null;
        }
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}