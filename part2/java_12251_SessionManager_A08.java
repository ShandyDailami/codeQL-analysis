import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12251_SessionManager_A08 {
    private static Connection connection;

    // Method to establish a connection to the database
    public static Connection establishConnection() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // Method to check if the session exists
    public static boolean isSessionValid() {
        boolean isValid = true;

        try {
            if (connection == null || connection.isClosed()) {
                isValid = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    public static void main(String[] args) {
        // Establish a connection
        establishConnection();

        // Check if the session exists
        if (isSessionValid()) {
            System.out.println("Session is valid");
        } else {
            System.out.println("Session is not valid");
        }
    }
}