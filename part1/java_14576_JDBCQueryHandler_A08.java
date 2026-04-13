import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14576_JDBCQueryHandler_A08 {
    // Create a database URL
    private final String url = "jdbc:mysql://localhost:3306/db_test";
    // Database username
    private final String username = "root";
    // Database password
    private final String password = "password";

    // Create a connection to the database
    private Connection connection;

    public java_14576_JDBCQueryHandler_A08() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    // Execute a SQL query
    public void executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        queryHandler.executeQuery("SELECT * FROM users");
        queryHandler.closeConnection();
    }
}