import java.sql.*;

public class java_19976_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Assuming the username is unique and is passed as a parameter
            pstmt.setString(1, "testuser");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");
                System.out.println("User: " + usernameDB + ", Password: " + passwordDB);
            }
        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
       }
    }
}