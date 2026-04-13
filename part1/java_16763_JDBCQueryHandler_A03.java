import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16763_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "user";
        String password = "password";

        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Create a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Step 3: Perform a query
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "admin"); // Use a trusted user
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String username = result.getString("username");
                    System.out.println("Username: " + username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}