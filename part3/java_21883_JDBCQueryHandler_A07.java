import java.sql.*;

public class java_21883_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_21883_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute the query
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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