import java.sql.*;

public class java_39849_JDBCQueryHandler_A03 {
    // Your database connection information goes here
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";

    // Create a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Use a parameterized query to prevent SQL injection
    public ResultSet executeQuery(String query, Object... parameters) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        // Set the parameters
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeQuery();
    }

    // Use a parameterized statement to prevent SQL injection
    public void executeUpdate(String query, Object... parameters) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        // Set the parameters
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        statement.executeUpdate();
    }

    // Close the connection
    public void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}