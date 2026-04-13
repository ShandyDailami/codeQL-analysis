public class java_08388_SessionManager_A08 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();

    private java_08388_SessionManager_A08() {
        // Private constructor to prevent instantiation of the class.
    }

    public static Session getSession() {
        Session session = sessionThreadLocal.get();
        if (session == null) {
            // Create a new session and store it in the ThreadLocal.
            session = createSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    private static Session createSession() {
        // Create and return a new Session object.
        // This is a placeholder and does not actually create a database session.
        return new Session();
    }

    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        if (session != null) {
            // Close the session and remove it from the ThreadLocal.
            session.close();
            sessionThreadLocal.set(null);
        }
    }
}