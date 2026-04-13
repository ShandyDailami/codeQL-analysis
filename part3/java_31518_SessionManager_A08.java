public class java_31518_SessionManager_A08 {
    // Private field to store the current session
    private static Session currentSession;

    // Private constructor to prevent instantiation
    private java_31518_SessionManager_A08() {}

    // Public method to get the current session
    public static Session getCurrentSession() {
        if (currentSession == null) {
            // Create a new session
            currentSession = HibernateUtil.getSessionFactory().openSession();
        }
        return currentSession;
    }

    // Public method to close the current session
    public static void closeCurrentSession() {
        if (currentSession != null) {
            currentSession.close();
            currentSession = null;
        }
    }
}