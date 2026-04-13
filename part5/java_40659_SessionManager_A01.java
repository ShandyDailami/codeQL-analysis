public class java_40659_SessionManager_A01 {
    // Private instance of SessionManager
    private javax.sql.SessionManager sessionManager;

    // Constructor
    public java_40659_SessionManager_A01(javax.sql.SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    // Method to start a session
    public javax.sql.Session startSession() {
        // Get a session from the SessionManager
        javax.sql.Session session = sessionManager.beginSession();
        // Make sure the session is opened
        if (session == null) {
            throw new RuntimeException("Unable to obtain a session from the session manager");
        }
        // Return the session
        return session;
    }

    // Method to close a session
    public void closeSession(javax.sql.Session session) {
        // Try to close the session
        if (session != null) {
            session.close();
        }
    }
}