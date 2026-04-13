import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_22119_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "new_password");
            pstmt.setString(2, "new_username");
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Affected rows: " + affectedRows);
            } else {
                System.out.println("No rows were updated");
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}