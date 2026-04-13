import java.sql.*;

public class java_40405_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String SQL = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, "valid_user");
            pstmt.setString(2, "valid_password");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Authentication Successful");
            } else {
                System.out.println("Authentication Failed");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
        }
    }
}