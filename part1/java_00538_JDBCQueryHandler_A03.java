import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00538_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Found user!");
            } else {
                System.out.println("User not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}