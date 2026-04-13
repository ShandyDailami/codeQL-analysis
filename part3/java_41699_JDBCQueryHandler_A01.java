import java.sql.*;

public class java_41699_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testuser"); // Test user

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String usernameDb = rs.getString("username");
                String passwordDb = rs.getString("password");
                System.out.println("username: " + usernameDb + ", password: " + passwordDb);
            }
        } catch (SQLException e) {
            System.out.println("Error in accessing the database: " + e.getMessage());
        }
    }
}