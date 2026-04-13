import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class java_25874_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.next();

        System.out.println("Enter password:");
        String password = scanner.next();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Prepare the SQL statement
            Statement statement = connection.createStatement();

            // Execute the SQL statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username ='" + username + "' AND password='" + password + "'");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("User found!");
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}