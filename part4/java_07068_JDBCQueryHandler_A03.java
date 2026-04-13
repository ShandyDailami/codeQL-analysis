import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_07068_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // Insecure SQL query
    private static final String INSECURE_QUERY = "SELECT * FROM users WHERE username = '" + "?username" + "'";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            PreparedStatement statement = connection.prepareStatement(INSECURE_QUERY);

            // Inject a malicious username into the query
            statement.setString(1, "admin'--");

            // Execute the query
            statement.executeUpdate();

            System.out.println("User updated successfully");
        } catch (SQLException e) {
            System.out.println("Error while updating user: " + e.getMessage());
        }
    }
}