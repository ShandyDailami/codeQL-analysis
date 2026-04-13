import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18538_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            conn.setReadOnly(false); // Disable auto-commit mode
            conn.setAutoCommit(false); // Disable auto-commit mode
            conn.prepareStatement(sql).execute(args); // Execute SQL statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}