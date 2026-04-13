import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00148_JDBCQueryHandler_A01 {

    private static final String databaseUrl = "your-database-url";
    private static final String username = "your-username";
    private static final String password = "your-password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open Connection
            conn = DriverManager.getConnection(databaseUrl, username, password);

            // Step 3: Create Statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL Query
            rs = stmt.executeQuery("SELECT * FROM your-table-name");

            // Step 5: Process Result
            while (rs.next()) {
                // Process your data here
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close Resources
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