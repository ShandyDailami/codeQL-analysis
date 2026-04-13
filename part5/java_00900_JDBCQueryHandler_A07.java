import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

public class java_00900_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // Bcrypt instance
    private static final BCrypt BCRYPT = new BCrypt();

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Connect to database
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            // Perform security-sensitive operation here
            String username = "user1";
            String password = "password1";

            // Hash password
            String hashedPassword = BCRYPT.hash(password);

            // Insert hashed password into database
            String insertQuery = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + hashedPassword + "')";
            statement.executeUpdate(insertQuery);

            // Retrieve password from database and compare
            String selectQuery = "SELECT password FROM users WHERE username = '" + username + "'";
            ResultSet result = statement.executeQuery(selectQuery);
            if (result.next()) {
                String dbPassword = result.getString(1);
                if (BCRYPT.checkpw(password, dbPassword)) {
                    System.out.println("Authentication successful.");
                } else {
                    System.out.println("Authentication failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
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