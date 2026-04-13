import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_10712_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the SQL statement
            preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Set the parameters
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");

            // Execute the SQL statement
            preparedStatement.executeUpdate();

            // Retrieve the user
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM users WHERE username = ?");
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Password: " + resultSet.getString("password"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}