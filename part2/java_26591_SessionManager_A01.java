public class java_26591_SessionManager_A01 {
    private Session session;

    public java_26591_SessionManager_A01(String connectionString, String user, String password) {
        try {
            session = DriverManager.getConnection(connectionString, user, password).createSession();
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing database connection.", e);
        }
    }

    public Session getSession() {
        return session;
    }

    public void startSession() {
        try {
            session.beginRequest();
        } catch (SQLException e) {
            throw new RuntimeException("Error starting session.", e);
        }
    }

    public void endSession() {
        try {
            session.completeRequest();
        } catch (SQLException e) {
            throw new RuntimeException("Error ending session.", e);
        }
    }
}