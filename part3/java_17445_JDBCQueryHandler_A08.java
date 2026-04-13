import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_17445_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Step 1: Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Create query
            String query = "UPDATE my_table SET my_column = ? WHERE id = ?";
            statement = connection.prepareStatement(query);

            // Step 4: Set parameters
            statement.setInt(1, 123); // Replace with actual value
            statement.setInt(2, 456); // Replace with actual value

            // Step 5: Execute query
            statement.executeUpdate();

            System.out.println("Update successful!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Step 6: Clean up
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) { /* ignore */ }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { /* ignore */ }
            }
        }
    }
}