import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07839_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    private java_07839_SessionManager_A07() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to connect to the database");
        }
    }
}