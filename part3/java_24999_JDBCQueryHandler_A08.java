import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24999_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Create a statement object
            try (Statement statement = connection.createStatement()) {
                // Execute a SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name = 'test'");

                while (resultSet.next()) {
                    // Access the columns
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    // Do something with the results...

                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                }
            }

            // Handle exceptions
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}