import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_39832_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Setup JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // Create a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "invalid_username");
                statement.setString(2, "invalid_password");

                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        System.out.println("Authentication failed for user: " + result.getString("username"));
                    } else {
                        System.out.println("No user found with the provided credentials");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database");
            e.printStackTrace();
        }
    }
}