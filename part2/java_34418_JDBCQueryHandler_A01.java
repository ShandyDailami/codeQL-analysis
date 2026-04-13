import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34418_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to MySQL database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "username", "password");

            // Create a new statement
            stmt = conn.createStatement();

            // Execute a SQL query
            rs = stmt.executeQuery("SELECT * FROM table_name");

            // Extract data from result set
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
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