import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15573_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Step 1: Register the driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // Step 2: Establish the connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password")) {
            System.out.println("Connected to the database");

            // Step 3: Execute a query
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM users WHERE username = 'testuser' AND password = 'testpassword'";
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    System.out.println("User found");
                } else {
                    System.out.println("User not found");
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}