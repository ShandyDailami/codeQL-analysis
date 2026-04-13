public class java_00783_SessionManager_A03 {

    // The unique instance of the SessionManager
    private static SessionManager sessionManager;

    // The session object
    private Session session;

    // Private constructor to prevent creation of new instances
    private java_00783_SessionManager_A03() {
        // Use the standard library for creating a new session
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Returns the singleton instance of the SessionManager
    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // Closes the session
    public void closeSession() {
        session.close();
        sessionManager = null;
    }

    // Opens a new session
    public void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    // Returns the current session
    public Session getSession() {
        return session;
    }
}