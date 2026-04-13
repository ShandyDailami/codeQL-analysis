import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_10083_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}