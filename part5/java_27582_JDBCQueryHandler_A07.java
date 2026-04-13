import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_27582_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_db";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    public void handleAuthFailure() {
        // Connect to the database
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query
            String query = "UPDATE your_table SET status = ? WHERE id = ?";
            statement = connection.prepareStatement(query);

            // Set parameter values
            statement.setString(1, "LOCKED");
            statement.setInt(2, 123);

            // Execute the query
            statement.executeUpdate();

            System.out.println("User with ID 123 has been locked out");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}