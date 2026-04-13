import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01145_SessionManager_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get a connection from the pool
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Use the connection to do something...

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}