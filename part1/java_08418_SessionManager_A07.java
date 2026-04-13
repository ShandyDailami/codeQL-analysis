import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08418_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private java_08418_SessionManager_A07() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connected to the database!");
            // Add your code here
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}