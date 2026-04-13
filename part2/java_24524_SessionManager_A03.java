import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24524_SessionManager_A03 {

    // Establish a connection to the database
    private Connection connection;

    // Constructor
    public java_24524_SessionManager_A03(String dbURL, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to perform database operations
    public void performOperation(String operation) {
        try {
            if (connection != null && !connection.isClosed()) {
                // Perform the operation on the connection object
                System.out.println("Performing " + operation + " on database");
            } else {
                System.out.println("No database connection available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        sessionManager.performOperation("SELECT");
    }
}