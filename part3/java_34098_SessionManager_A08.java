import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34098_SessionManager_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Use the connection
            System.out.println("Connected to database");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection");
                    e.printStackTrace();
                }
            }
        }
    }
}