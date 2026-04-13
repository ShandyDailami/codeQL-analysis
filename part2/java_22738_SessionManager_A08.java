public class java_22738_SessionManager_A08 {
    private javax.sql.DataSource dataSource;

    public java_22738_SessionManager_A08(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void startSession() throws Exception {
        // Check if a session is already active
        if (Thread.activeCount() > 1) {
            throw new Exception("Only one session can be active at a time.");
        }

        // Create a new session
        Session session = dataSource.getConnection().createSession(true, true);

        // Check if the session is not null
        if (session == null) {
            throw new Exception("Session is null.");
        }

        // Perform a security-sensitive operation
        try {
            // Example: Verify the session's integrity
            if (session.getTransaction().getStatus() == javax.sql.Session.SUCCESS) {
                System.out.println("Session is in a valid state.");
            } else {
                throw new Exception("Session is not in a valid state.");
            }
        } finally {
            // End the session
            session.end();
        }
    }
}