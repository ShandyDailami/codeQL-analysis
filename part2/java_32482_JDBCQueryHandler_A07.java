import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_32482_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector not found");
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 3: Prepare and execute the query
            String query = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "testuser");
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    String dbPassword = result.getString("password");
                    System.out.println("Password from DB: " + dbPassword);
                } else {
                    System.out.println("No user found with the provided username");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }
}