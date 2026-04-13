import java.sql.*;

public class java_37602_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Establish a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:your_database_url", DB_USERNAME, DB_PASSWORD);
    }

    // Execute a query and return a ResultSet
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Execute a non-query (e.g., UPDATE, INSERT, DELETE) and return a ResultSet (for INSERT operations)
    public int executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler();
            ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}