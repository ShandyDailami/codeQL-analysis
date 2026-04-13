import java.sql.*;

public class java_36660_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_36660_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            statement = connection.prepareStatement(query);

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handle the result
            while (resultSet.next()) {
                // Assume the result set contains strings, you may need to handle them differently
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the connection, regardless of whether an exception occurred
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