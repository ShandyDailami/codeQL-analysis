import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_13748_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        try {
            // Loading database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC", "username", "password");

            // Prepare SQL
            String query = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameter values
            pstmt.setString(1, "newpassword"); // new password
            pstmt.setString(2, "newuser"); // user

            // Execute update SQL
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated password for user: " + newuser);
            } else {
                System.out.println("No rows were updated");
            }

            // Close connection
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}