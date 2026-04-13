import java.sql.*;

public class java_26427_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Prepare statement
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set parameter
            pstmt.setString(1, "testUser");

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}