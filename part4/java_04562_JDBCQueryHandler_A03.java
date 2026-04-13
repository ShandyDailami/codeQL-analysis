import java.sql.*;

public class java_04562_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "test@example.com"); // this is a sample injection

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                // handle the email here
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}