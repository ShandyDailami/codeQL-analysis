import java.sql.*;

public class java_16183_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle the result
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

            // Step 5: Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Step 6: Clean up connections
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }
}