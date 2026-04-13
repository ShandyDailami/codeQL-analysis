import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35097_SessionManager_A08 {

    public static void main(String[] args) {
        // Establish a connection to a database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:yourDatabase", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Verify the integrity of the connection
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection is valid.");
            } else {
                System.out.println("Connection is invalid.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Use the connection for operations
        // ...

        // Close the connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}