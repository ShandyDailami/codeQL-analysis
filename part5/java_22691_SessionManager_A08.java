import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22691_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    // In a real-world application, you should use a more secure way to handle the password
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        // Trying to establish a new session
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}