import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20285_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("User exists");
            } else {
                System.out.println("User does not exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}