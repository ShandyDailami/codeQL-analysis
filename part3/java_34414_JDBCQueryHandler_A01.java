import java.sql.*;

public class java_34414_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "validUser"); // Replace with the username of a user that has access
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password"); // Assuming password field contains hashed password
                // Now you can use the username and password for further operations
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}