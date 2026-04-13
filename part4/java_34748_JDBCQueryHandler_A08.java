import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_34748_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:your_database_url", "username", "password")) {

            // Step 2: Create a PreparedStatement
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE your_table SET your_column = ? WHERE id = ?")) {

                // Step 3: Set the parameters and execute the statement
                statement.setString(1, "new_value"); // Replace 'new_value' with the new value you want to set
                statement.setInt(2, 123); // Replace '123' with the id of the row you want to update
                statement.executeUpdate();

                System.out.println("Row updated successfully.");

            } catch (SQLException e) {
                System.out.println("Error updating row: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}