public class java_39465_SessionManager_A01 {
    private static int sessionCount = 0;
    private Session session;

    public java_39465_SessionManager_A01() {
        sessionCount++;
        session = createSession();
        if (sessionCount > 1) {
            closeSession(session);
        }
    }

    private Session createSession() {
        // Code to create a new session goes here. This would involve using a connection pooling library.
        // For now, this method will just return null.
        return null;
    }

    private void closeSession(Session session) {
        // Code to close the session goes here. This would involve using a connection pooling library.
        // For now, this method will just do nothing.
        // session.close();
    }

    public void doSecuritySensitiveOperation(String param) {
        // This is a security-sensitive operation.
        // It would use the session to perform a database operation.
        // This example does not actually perform the operation.
        // Instead, it's just a demonstration of how one might use the session to perform a database operation.

        if (session == null) {
            throw new RuntimeException("No session exists.");
        }

        // The actual code for doing the database operation would go here.
        // For example, if session is a JDBC Connection, we could do something like:

        // session.createStatement().execute("SELECT * FROM Users WHERE Name = '" + param + "'");
    }
}