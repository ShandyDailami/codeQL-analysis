import java.sql.*;

public class java_29123_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_29123_JDBCQueryHandler_A08(String dbUrl, String userName, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, userName, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // Process the result set
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}