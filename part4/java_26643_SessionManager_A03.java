import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_26643_SessionManager_A03 {
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    static {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Load database configuration
        url = "jdbc:mysql://localhost:3306/test";
        username = "root";
        password = "root";
    }

    private java_26643_SessionManager_A03() {
        // Prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Failed to connect!");
        }
        closeConnection();
    }
}