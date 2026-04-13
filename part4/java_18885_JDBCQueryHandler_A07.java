import java.sql.*;

public class java_18885_JDBCQueryHandler_A07 {

    // Fields to store database connection information
    private String url;
    private String username;
    private String password;

    // Constructor to initialize the connection
    public java_18885_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to run the query
    public ResultSet runQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement from the connection
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
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

        return resultSet;
    }
}