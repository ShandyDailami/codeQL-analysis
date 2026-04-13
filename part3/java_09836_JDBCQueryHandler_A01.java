import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09836_JDBCQueryHandler_A01 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the result
            while (rs.next()) {
                String user = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}