public class java_21211_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_21211_SessionManager_A01() {
        // Hide constructor for Singleton
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session openSession() {
        // Assume that opening a session is a fairly common operation.
        // If opening a session fails, handle it appropriately.
        session = SessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    public Session getSession() {
        return session;
    }
}