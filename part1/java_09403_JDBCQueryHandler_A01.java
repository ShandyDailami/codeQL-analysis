import java.sql.*;

public class java_09403_JDBCQueryHandler_A01 {
    // The data source name. This will be set in the constructor.
    private String dataSourceName;

    // Constructor
    public java_09403_JDBCQueryHandler_A01(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            connection = DriverManager.getConnection(dataSourceName);

            // Create a statement
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);

            // Return the ResultSet
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Method to execute a non-query (like INSERT, UPDATE, DELETE)
    public int executeNonQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        int result = 0;

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            connection = DriverManager.getConnection(dataSourceName);

            // Create a statement
            statement = connection.createStatement();

            // Execute the non-query
            result = statement.executeUpdate(query);

            // Return the result
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}