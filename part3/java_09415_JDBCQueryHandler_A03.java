import java.sql.*;

public class java_09415_JDBCQueryHandler_A03 {

    //Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Perform a security-sensitive operation
            String sql = "UPDATE users SET password = ? WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "new_password");
            pstmt.setString(2, "user@example.com");
            pstmt.executeUpdate();

            // Close connection
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}