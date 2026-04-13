import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05137_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private java_05137_SessionManager_A03() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
}