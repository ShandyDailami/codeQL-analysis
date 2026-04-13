public class java_02123_SessionManager_A01 {
    // Use a ConnectionPool to manage database connections.
    private ConnectionPool connectionPool;

    public java_02123_SessionManager_A01() {
        // Initialize connection pool with standard connection parameters.
        connectionPool = new ConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "username", "password", 5, 5);
    }

    public Connection getConnection() {
        // Get a connection from the connection pool.
        return connectionPool.getConnection();
    }

    public void closeConnection(Connection connection) {
        // Return a connection back to the connection pool.
        connectionPool.returnConnection(connection);
    }
}