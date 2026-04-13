import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24473_SessionManager_A03 {

    // Create a static reference to the connection
    private static Connection connection = null;

    // Private constructor to restrict instantiation of this class
    private java_24473_SessionManager_A03() {
        throw new UnsupportedOperationException();
    }

    // Method to establish a connection
    public static Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "password";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}