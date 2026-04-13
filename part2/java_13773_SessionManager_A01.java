import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_13773_SessionManager_A01 {
    // You can use a database URL and username/password for testing purposes
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    // Broken Access Control
    public java_13773_SessionManager_A01(String username, String password) {
        this.connection = DriverManager.getConnection(DATABASE_URL, username, password);
    }

    // This method should only be called when the object has a valid connection
    public void executeQuery(String query) {
        try {
            this.connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    // This method is used to close the connection when the object is no longer needed
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}