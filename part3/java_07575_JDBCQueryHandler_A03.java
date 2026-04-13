import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07575_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql, "newuser", "password");
            }

            String sql2 = "SELECT * FROM users WHERE username = ?";
            try (Statement stmt2 = conn.createStatement()) {
                try (ResultSet rs = stmt2.executeQuery(sql2, "newuser")) {
                    if (rs.next()) {
                        System.out.println("Found user: " + rs.getString("username"));
                    } else {
                        System.out.println("User not found");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}