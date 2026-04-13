import java.sql.*;
import java.util.logging.*;

public class java_34019_JDBCQueryHandler_A08 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());
    private static final String DB_URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public void executeQuery() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT * FROM your_table";  // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // process each result set row here
            }

            LOGGER.info("Query executed successfully.");
        } catch (SQLException e) {
            LOGGER.severe("Failed to execute query: " + e.getMessage());
       
        } finally {
            // close the resources in reverse order
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    LOGGER.severe("Failed to close statement: " + e.getMessage());
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.severe("Failed to close connection: " + e.getMessage());
                }
            }
        }
    }
}