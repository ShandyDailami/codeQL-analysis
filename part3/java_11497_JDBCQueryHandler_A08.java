import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11497_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Create your SQL query here and execute it
            String query = "SELECT * FROM table_name WHERE id = ?";
            connection.prepareStatement(query).executeUpdate(123); // Replace with the actual id
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}