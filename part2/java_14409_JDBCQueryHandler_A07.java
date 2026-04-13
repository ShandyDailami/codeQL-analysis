import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14409_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Create a statement
            try (Statement statement = connection.createStatement()) {

                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

                // Process the result set
                while (resultSet.next()) {
                    System.out.println("Record " + resultSet.getInt("id") + ": " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error processing the database: " + e.getMessage());
        }
    }
}