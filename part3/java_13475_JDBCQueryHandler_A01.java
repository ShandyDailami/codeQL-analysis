import java.sql.*;

public class java_13475_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_13475_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish the database connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL query
            statement = connection.createStatement();

            // Step 3: Execute the SQL query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Clean up (Disconnect from the database, close the statement, and close the connection if they're open)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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