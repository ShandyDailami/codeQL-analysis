import java.sql.*;

public class java_26015_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "user1"); // replace "user1" with the actual username

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user found with the provided username.");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}