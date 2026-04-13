import java.sql.*;

public class java_17906_JDBCQueryHandler_A03 {
    // Define the database connection URL, username, and password
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    // Get the connection from the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Execute a query and return the result
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    // Execute a statement without returning the result
    public void executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    // Close the connection
    public void closeConnection(Connection connection, Statement statement) throws SQLException {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}