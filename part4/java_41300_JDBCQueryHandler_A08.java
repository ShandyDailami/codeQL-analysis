import java.sql.*;
import java.util.Properties;

public class java_41300_JDBCQueryHandler_A08 {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            // Set up the database connection
            Properties properties = new Properties();
            properties.setProperty("user", "your_username");
            properties.setProperty("password", "your_password");
            properties.setProperty("url", "jdbc:mysql://your_host:your_port/your_database");
            connection = DriverManager.getConnection("jdbc:mysql://your_host:your_port/your_database", properties);
            statement = connection.createStatement();

            // Create a new user
            String insertUser = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            executeQuery(insertUser);

            // Fetch a user
            String fetchUser = "SELECT * FROM users WHERE username = 'user1'";
            ResultSet resultSet = executeQuery(fetchUser);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Update a user
            String updateUser = "UPDATE users SET password = 'new_password1' WHERE username = 'user1'";
            executeQuery(updateUser);

            // Delete a user
            String deleteUser = "DELETE FROM users WHERE username = 'user1'";
            executeQuery(deleteUser);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}