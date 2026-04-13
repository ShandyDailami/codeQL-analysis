public class java_39333_SessionManager_A08 {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    private java_39333_SessionManager_A08() {
        // Private constructor to prevent instantiation from outside
    }

    public static Session openSession() {
        Connection connection = null;
        Session session = null;

        try {
            // Open a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            connection.setAutoCommit(false);

            // Open a session
            session = connection.openSession();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Store the connection and session in thread local variables
        connectionThreadLocal.set(connection);
        sessionThreadLocal.set(session);

        return session;
    }

    public static void main(String[] args) {
        Session session = openSession();
        session.beginTransaction();

        // Your code here

        session.getTransaction().commit();
        session.close();

        connectionThreadLocal.get().close();
    }
}