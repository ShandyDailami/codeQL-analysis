import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_37671_CredentialValidator_A03 {

    // You can use any SQL database with JDBC
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            // Assume that you have a table named "users" and it has a column "username"
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "user1"); // user1 from your form
            pstmt.setString(2, "password1"); // password1 from your form

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Valid credentials");
            } else {
                System.out.println("Invalid credentials");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}