import java.sql.*;
import java.util.logging.*;

public class java_35824_JDBCQueryHandler_A03 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    public static void main(String[] args) {
        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            LOGGER.info("Connected to the database successfully.");
        } catch (SQLException e) {
            LOGGER.severe("Failed to connect to the database: " + e.getMessage());
            System.exit(-1);
        }

        // Prepare a statement for executing queries
        Statement statement = null;
        try {
            statement = connection.createStatement();
            LOGGER.info("Statement created successfully.");
        } catch (SQLException e) {
            LOGGER.severe("Failed to create statement: " + e.getMessage());
        }

        // Execute a query
        String query = "SELECT * FROM users WHERE id = " + args[0];
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            LOGGER.info("Query executed successfully.");
        } catch (SQLException e) {
            LOGGER.severe("Failed to execute query: " + e.getMessage());
        }

        // Process the result set
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LOGGER.info("Found user: " + name + ", " + email);
            }
        } catch (SQLException e) {
            LOGGER.severe("Failed to process result set: " + e.getMessage());
        }

        // Close the connection
        try {
            resultSet.close();
            statement.close();
            connection.close();
            LOGGER.info("Connection closed successfully.");
        } catch (SQLException e) {
            LOGGER.severe("Failed to close connection: " + e.getMessage());
        }
    }
}