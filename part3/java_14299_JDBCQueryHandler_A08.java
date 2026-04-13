import java.sql.*;

public class java_14299_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_USERNAME = "<DB_USERNAME>";
    private static final String DB_PASSWORD = "<DB_PASSWORD>";
    private static final String DB_URL = "<DB_URL>";

    // Create a connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return connection;
    }

    // Execute a query
    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ColumnName1") + " " + resultSet.getString("ColumnName2"));
            }
        } catch (SQLException e) {
            System.out.println("Query execution failed");
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Closing failed");
                e.printStackTrace();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("<SQL_Query>");
    }
}