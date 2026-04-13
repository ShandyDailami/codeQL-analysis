import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_10924_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String userId = rs.getString("userId");
                String userName = rs.getString("userName");
                String email = rs.getString("email");

                System.out.println("User ID: " + userId);
                System.out.println("User Name: " + userName);
                System.out.println("Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}