import java.sql.*;

public class java_14567_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in connecting to the database: " + e.getMessage());
        }
    }
}