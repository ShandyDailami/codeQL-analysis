import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01485_SessionManager_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection successful!");

            // Example of security-sensitive operation related to injection
            String injectionExample = "injection";
            System.out.println("Attempting to execute injection: " + injectionExample);

            // The following line is a placeholder for a secure operation
            conn.createStatement().executeUpdate("DROP TABLE IF EXISTS " + injectionExample);

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}