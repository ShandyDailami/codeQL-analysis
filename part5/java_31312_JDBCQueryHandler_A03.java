import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_31312_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Inject a malicious id into the query
            statement.setInt(1, 10001);

            // Execute the query
            statement.execute();

            // No need for ResultSet here, as we are not fetching any data

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}