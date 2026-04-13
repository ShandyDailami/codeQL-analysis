import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41327_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish the database connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a new SQL query
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Set the parameters for the query
                statement.setString(1, "user1");
                statement.setString(2, "password1");

                // Execute the query
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // User exists and has valid credentials
                        System.out.println("User exists and has valid credentials");
                    } else {
                        // User does not exist or does not have valid credentials
                        System.out.println("User does not exist or does not have valid credentials");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}