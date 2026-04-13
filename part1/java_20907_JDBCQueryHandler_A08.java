import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20907_JDBCQueryHandler_A08 {
    // Connection URL, username, and password for database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    // Method to create a connection
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Method to execute SQL query and return result
    public ResultSet executeQuery(String query) throws SQLException {
        // Establish connection
        Connection connection = createConnection();

        // Open statement
        Statement statement = connection.createStatement();

        // Execute query and get result
        ResultSet result = statement.executeQuery(query);

        // Close connection
        connection.close();

        return result;
    }

    // Method to perform security-sensitive operations
    public void securitySensitiveOperations() {
        // Assume that we're executing a SELECT query
        try {
            String query = "SELECT * FROM sensitive_table";
            ResultSet result = executeQuery(query);

            // Process the result set
            while (result.next()) {
                String column1 = result.getString("column1");
                String column2 = result.getString("column2");

                // Perform security-sensitive operations with the columns
                // For example, print the values to the console
                System.out.println("Column1: " + column1);
                System.out.println("Column2: " + column2);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.securitySensitiveOperations();
    }
}