import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28231_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Security-sensitive operations, e.g., altering a table
            // Here, let's say we want to add a new column to a table
            // The SQL statement would look something like this:
            String alterTableQuery = "ALTER TABLE test_table ADD COLUMN new_column INT";
            connection.createStatement().execute(alterTableQuery);

            System.out.println("Successfully altered the table!");

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}