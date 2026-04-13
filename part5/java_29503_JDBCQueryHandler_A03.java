import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29503_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String dbUsername = rs.getString("username");
                if (args[0].equals(dbUsername)) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            } else {
                System.out.println("No user found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}