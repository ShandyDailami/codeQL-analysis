import java.sql.*;

public class java_32816_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Create a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Close the connection
    public void close(Connection connection) throws SQLException {
        connection.close();
    }

    // Execute a query
    public ResultSet executeQuery(Connection connection, String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try (Connection connection = handler.getConnection();
             ResultSet resultSet = handler.executeQuery(connection, "SELECT * FROM users")) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}