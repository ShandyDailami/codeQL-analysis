import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_30375_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Users WHERE username = 'user1' AND password = 'pass1'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Found user");
            } else {
                System.out.println("No user found");
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database");
            e.printStackTrace();
        }
    }
}