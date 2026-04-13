import java.sql.*;

public class java_11187_JDBCQueryHandler_A07 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Function to authenticate user
    public static boolean authenticate(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare a statement
            stmt = conn.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME ='" + username + "' AND PASSWORD ='" + password + "'");

            // If there are any results, then print it
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
            return false;
        } finally {
            // Clean up environment
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(authenticate("user", "password"));
    }
}