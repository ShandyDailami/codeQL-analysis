import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03549_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Perform a security-sensitive operation (e.g., querying a database for a specific user)
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "user1");
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    System.out.println("User found: " + result.getString("username"));
                }
            }

            // Close the connection
            connection.close();
            System.out.println("Disconnected from the database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}