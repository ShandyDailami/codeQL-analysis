import java.sql.*;

public class java_35763_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, "invalid_username"); // Invalid username

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}