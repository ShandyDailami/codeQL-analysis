import java.sql.*;

public class java_35886_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_35886_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Get a connection to the database
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement from the connection
            statement = connection.createStatement();

            // Step 3: Execute the query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Clean up resources
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

        return resultSet;
    }
}