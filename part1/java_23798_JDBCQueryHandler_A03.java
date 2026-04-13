import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23798_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Step 3: Use connection object for your operation
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "testUser");
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String username = result.getString("username");
                    String password = result.getString("password");
                    System.out.println("Username: " + username + ", Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}