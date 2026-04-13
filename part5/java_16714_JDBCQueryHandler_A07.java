import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16714_JDBCQueryHandler_A07 {

    // URL to connect to the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Register MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Perform a security-sensitive operation here, for example, a query
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            conn.prepareStatement(sql).executeQuery(new String[]{"user1", "password1"});
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
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