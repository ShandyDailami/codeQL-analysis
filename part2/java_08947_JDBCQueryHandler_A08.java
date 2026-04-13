import java.sql.*;

public class java_08947_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection connection;

    public static void main(String[] args) {
        connection = null;

        try {
            // Create a connection
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Create a new user
            String createUserQuery = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            statement.executeUpdate(createUserQuery);

            // Retrieve a user
            String retrieveUserQuery = "SELECT * FROM users WHERE username = 'user1'";
            ResultSet resultSet = statement.executeQuery(retrieveUserQuery);

            if (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            } else {
                System.out.println("User not found");
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}