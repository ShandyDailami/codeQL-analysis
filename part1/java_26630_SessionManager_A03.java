import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26630_SessionManager_A03 {
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String username = "root";
    private static String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        getConnection();
    }

    private static void getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection successful!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed. Please check the url, username, and password.");
            e.printStackTrace();
        }
    }
}