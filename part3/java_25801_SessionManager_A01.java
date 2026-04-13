public class java_25801_SessionManager_A01 {

    private javax.sql.Session session;

    public void startSession() {
        // You would typically use a database connection pool instead of a static session here
        // This is kept simple for demonstration purposes
        session = javax.sql.Session.getInstance("myConnectionPoolName");
    }

    public void endSession() {
        // You would typically return the session to the connection pool here
        // This is kept simple for demonstration purposes
        session.close();
    }
}