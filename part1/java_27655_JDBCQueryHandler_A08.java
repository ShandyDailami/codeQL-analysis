import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27655_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mydatabase", "username", "password");

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            rs = stmt.executeQuery("SELECT * FROM my_table");

            // Step 5: Process the result set
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
}