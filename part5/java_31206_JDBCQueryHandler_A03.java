import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31206_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set parameter value
            pstmt.setInt(1, 101);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException ex) {
            System.out.println("Error in JDBC connection");
            ex.printStackTrace();
        }
    }
}