import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_03209_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM table_name WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, 123); // Example value for id
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    // Process the result set
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query execution: " + e.getMessage());
        }
    }
}