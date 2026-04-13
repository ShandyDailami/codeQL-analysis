import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21110_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Create a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase",
                "username",
                "password")) {

            // Step 3: Execute a query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                // Step 4: Process the result
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}