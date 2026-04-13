import java.sql.*;

public class java_30755_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String usernameFromDB = rs.getString("username");
                String passwordFromDB = rs.getString("password");

                System.out.println("Username: " + usernameFromDB);
                System.out.println("Password: " + passwordFromDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}