import java.sql.*;

public class java_07006_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Set up the connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Run a secure operation
            String query = "SELECT * FROM Users WHERE Username = 'secureduser'";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                // Do something with the username and password
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the statement and connection
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
    }
}