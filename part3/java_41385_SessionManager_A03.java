import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41385_SessionManager_A03 {
    // URL of your database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    // Your username
    private static final String USERNAME = "root";
    // Your password
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_41385_SessionManager_A03() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        if (sessionManager.getConnection() != null) {
            System.out.println("Connected to the database successfully!");
        } else {
            System.out.println("Failed to connect to the database!");
        }
    }
}