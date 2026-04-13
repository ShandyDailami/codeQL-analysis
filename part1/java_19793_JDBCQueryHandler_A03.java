import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19793_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insert a new user
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            conn.prepareStatement(sql).executeUpdate();

            // Query the user
            sql = "SELECT * FROM users WHERE username = ?";
            conn.prepareStatement(sql).setString(1, "testUser").executeQuery();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}