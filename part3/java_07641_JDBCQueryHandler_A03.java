import java.sql.*;

public class java_07641_JDBCQueryHandler_A03 {
    // Define the database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // Method to perform a query
    public ResultSet executeQuery(String query) {
        try {
            // Create a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query and return a ResultSet
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
        }
        return null;
    }

    // Method to perform an insert, update, or delete query
    public int executeUpdate(String query) {
        try {
            // Create a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query and return the number of rows affected
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
        }
        return -1;
    }

    // Method to close the connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing the connection: " + e.getMessage());
        }
    }
}