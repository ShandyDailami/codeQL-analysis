public class java_12355_SessionManager_A07 {

    // Private instance of SessionManager
    private static volatile SessionManager sessionManager = null;

    // Private constructor to prevent instantiation
    private java_12355_SessionManager_A07() {}

    // Public method to get instance of SessionManager
    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            synchronized (SessionManager.class) {
                if (sessionManager == null) {
                    sessionManager = new SessionManager();
                }
            }
        }
        return sessionManager;
    }

    // Session object
    private HibernateSession hibernateSession;

    // Method to open a session
    public HibernateSession openSession() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        return hibernateSession;
    }

    // Method to close the session
    public void closeSession() {
        hibernateSession.close();
    }
}