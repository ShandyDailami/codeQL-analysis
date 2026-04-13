import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15004_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Establish a connection to the database
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a new statement
            try (Statement statement = connection.createStatement()) {
                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

                // Process the results
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    // Now we have the username and password, this is a security-sensitive operation
                    // We'll do something with them, such as storing them in a secure way
                    // In this case, we'll just print them
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}