import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37320_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Loading the Database Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establishing the Connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Step 3: Creating a Statement
            try (Statement statement = connection.createStatement()) {

                // Step 4: Executing a Query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'admin'");

                // Step 5: Processing the ResultSet
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }

            // Step 6: Closing the Connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}