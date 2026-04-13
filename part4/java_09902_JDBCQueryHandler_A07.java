import java.sql.*;
import java.util.logging.Logger;

public class java_09902_JDBCQueryHandler_A07 {
    private static final Logger LOGGER = Logger.getLogger(JDBCQueryHandler.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testUser"); // Set the user to test the query

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error executing JDBC query: " + e.getMessage());
        }
    }
}