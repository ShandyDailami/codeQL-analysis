import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40789_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = 'admin' AND password = 'password'";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println("Authenticated successfully");
                    } else {
                        System.out.println("Authentication failed");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}