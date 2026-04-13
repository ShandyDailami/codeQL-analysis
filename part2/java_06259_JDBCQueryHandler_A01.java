import java.sql.*;

public class java_06259_JDBCQueryHandler_A01 {

    // private fields for database connection and operations
    private Connection connection;
    private Statement statement;

    // Constructor
    public java_06259_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        this.statement = connection.createStatement();
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) throws SQLException {
        return this.statement.executeQuery(query);
    }

    // Method to execute a non-query (like INSERT, UPDATE, DELETE)
    public int executeNonQuery(String query) throws SQLException {
        return this.statement.executeUpdate(query);
    }

    // Method to close the database connection
    public void close() throws SQLException {
        this.statement.close();
        this.connection.close();
    }

    // Sample usage
    public static void main(String[] args) {
        try {
            // Create a new JDBCQueryHandler with your database connection details
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");

            // Execute a query
            ResultSet result = handler.executeQuery("SELECT * FROM your_table");

            // Process the result
            while (result.next()) {
                // Access the data
                String column1 = result.getString("column1");
                // ...
            }

            // Close the connection
            handler.close();

        } catch (SQLException e) {
            System.out.println("Error executing query or closing connection: " + e.getMessage());
        }
    }
}