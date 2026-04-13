import java.sql.*;

public class java_27958_JDBCQueryHandler_A07 {
    // The data source name
    private static final String DATA_SOURCE_NAME = "your_database";

    // The JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/test";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Extract data from result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean-up environment
            if (stmt != null) {
                try {stmt.close();} catch (SQLException e) { /* unable to do anything */ }
            }
            if (conn != null) {
                try {conn.close();} catch (SQLException e) { /* unable to do anything */ }
            }
        }
    }
}