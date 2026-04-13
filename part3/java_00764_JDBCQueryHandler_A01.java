import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00764_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // replace with your database URL
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM users"; // replace with your SQL query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("id"));
                System.out.println("User Name: " + rs.getString("username"));
                System.out.println("User Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}