public class java_11523_SessionManager_A03 {
    private static SessionManager sessionManager;

    private java_11523_SessionManager_A03() {
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    // This is a very basic way to create a session. In a real application, you would likely use a database connection and a transaction manager.
    public Session createSession() {
        Session session = (Session) JavaPersistenceManager.instance().createEntityManager();
        return session;
    }

    // This is a very basic way to close a session. In a real application, you would likely use a transaction manager.
    public void closeSession(Session session) {
        JavaPersistenceManager.instance().closeEntityManager(session);
    }
}