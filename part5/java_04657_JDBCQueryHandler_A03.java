import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_04657_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Insecure SQL query
    private static final String INSECURE_SQL = "SELECT * FROM users WHERE username = '%s' AND password = '%s'";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(String.format(INSECURE_SQL, DB_USERNAME, DB_PASSWORD))) {

            // Execute the SQL query
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("Affected rows: " + affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}