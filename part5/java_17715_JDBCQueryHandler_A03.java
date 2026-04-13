import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17715_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Establish a connection to the database
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            stmt = conn.createStatement();
            String sql = "your_query_here";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}