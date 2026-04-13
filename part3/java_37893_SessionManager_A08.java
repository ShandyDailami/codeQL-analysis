import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_37893_SessionManager_A08 {

    // URL to connect to the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    // Username to connect to the database
    private static final String USER = "root";
    // Password to connect to the database
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Prepare a SQL statement
            preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");

            // Insert user data
            preparedStatement.setString(1, "newUser");
            preparedStatement.setString(2, "password");

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            // Handle SQLException and ClassNotFoundException
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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