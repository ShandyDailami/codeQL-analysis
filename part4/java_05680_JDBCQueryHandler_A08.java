import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05680_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Ensure the use of secure practices
            conn.setAutoCommit(false);

            String sql = "INSERT INTO test_table (id, name) VALUES (1, 'Test')";
            stmt.executeUpdate(sql);

            // Ensure the use of secure practices
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}