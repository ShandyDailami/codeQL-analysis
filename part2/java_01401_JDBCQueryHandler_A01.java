import java.sql.*;
import java.util.Properties;

public class java_01401_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Connect to MySQL Database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL Database");

            // Step 2: Execute a query to retrieve a specific user
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username = 'testuser'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("User found");
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}