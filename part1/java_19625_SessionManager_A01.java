import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19625_SessionManager_A01 {

    // Connection URL for the database
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;";

    // User credentials for the database
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the SQL server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Security-sensitive operation: Access the database
            accessDatabase(conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection: " + e.getMessage());
                }
            }
        }
    }

    private static void accessDatabase(Connection conn) {
        // Security-sensitive operation: Access database without granting access
        // This is a dummy operation for demonstration purposes
        System.out.println("Accessing database without granting access...");
    }
}