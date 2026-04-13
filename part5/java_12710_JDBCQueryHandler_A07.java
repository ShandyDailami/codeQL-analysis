import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class java_12710_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {

            // Create a statement
            try (Statement statement = connection.createStatement()) {

                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'user' AND password = 'password'");
                
                // Process the result set
                while (resultSet.next()) {
                    System.out.println("User found: " + resultSet.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}