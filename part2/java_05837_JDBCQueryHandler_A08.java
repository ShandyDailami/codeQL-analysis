import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class java_05837_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // Bcrypt instance
    private static final BCrypt BCRYPT = new BCrypt();

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Create a connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Prepare a statement
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, "testUser");

            // Execute the statement
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Check the password
                if (BCrypt.checkpw("password", resultSet.getString("password"))) {
                    System.out.println("Access granted.");
                } else {
                    System.out.println("Access denied.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}