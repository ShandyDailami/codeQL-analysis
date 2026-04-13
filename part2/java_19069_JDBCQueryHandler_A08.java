import java.sql.*;

public class java_19069_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // SQL queries
    private static final String SQL_DELETE_QUERY = "DELETE FROM USERS WHERE ID = 1";
    private static final String SQL_UPDATE_QUERY = "UPDATE USERS SET NAME = 'John' WHERE ID = 1";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            statement = connection.createStatement();

            // Delete operation
            // statement.executeUpdate(SQL_DELETE_QUERY);

            // Update operation
            statement.executeUpdate(SQL_UPDATE_QUERY);

            System.out.println("Successfully deleted from database");

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