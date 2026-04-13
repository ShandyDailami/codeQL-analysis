import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31883_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            String sql = "SELECT * FROM users WHERE name = 'John'";
            rs = stmt.executeQuery(sql);

            // Process the results
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /*ignore*/ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /*ignore*/ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /*ignore*/ }
            }
        }
    }
}