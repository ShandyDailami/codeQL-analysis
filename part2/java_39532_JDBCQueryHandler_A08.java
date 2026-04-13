import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39532_JDBCQueryHandler_A08 {
    private final String url;
    private final String username;
    private final String password;

    public java_39532_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Execute the query and handle any results
            statement.executeQuery(query);
        } catch (SQLException e) {
            // Handle SQL exceptions if needed
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // Always close the resources
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Ignore error
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Ignore error
                }
            }
        }
    }
}