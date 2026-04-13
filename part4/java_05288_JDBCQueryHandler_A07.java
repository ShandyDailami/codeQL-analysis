import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class java_05288_JDBCQueryHandler_A07 {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private static final List<String> SAFE_QUERIES = Arrays.asList(
        "SELECT * FROM users WHERE id = ?",
        "INSERT INTO users (id, name) VALUES (?, ?)",
        "UPDATE users SET name = ? WHERE id = ?"
    );

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM users WHERE id = '1'"; // example query
            if (isQuerySafe(query)) {
                System.out.println("Safe query: " + query);
            } else {
                System.out.println("Unsafe query: " + query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isQuerySafe(String query) {
        for (String safeQuery : SAFE_QUERIES) {
            if (query.equals(safeQuery)) {
                return true;
            }
        }
        return false;
    }
}