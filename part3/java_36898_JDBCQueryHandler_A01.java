import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36898_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password")) {

            // Execute a query that includes a SQL injection
            try (Statement statement = connection.createStatement()) {
                String sql = "INSERT INTO users (username, password) VALUES ('testuser', 'testpassword')";
                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}