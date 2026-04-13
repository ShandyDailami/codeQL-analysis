import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08757_SessionManager_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private java_08757_SessionManager_A08() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        // use the connection for your operations
        connection.close();
    }
}