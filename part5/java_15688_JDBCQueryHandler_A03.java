import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15688_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    // Constructor
    public java_15688_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to perform a query
    public void performQuery(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            statement = connection.createStatement();

            // Execute the query
            statement.executeUpdate(query);

            System.out.println("Query executed successfully");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}