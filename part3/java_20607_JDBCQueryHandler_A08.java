import java.sql.*;

public class java_20607_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myUser";
    private static final String PASS = "myPassword";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT * FROM Users WHERE Email = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "test@test.com"); // This should be a legitimate email address

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                System.out.println("Email: " + email + ", Password: " + password);
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}