import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_25941_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public List<String> getUsersWithIntegrityFailure() {
        List<String> usersWithIntegrityFailure = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the driver
            Class.forName(DB_DRIVER);

            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare statement for database operations
            stmt = conn.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT username FROM users WHERE password = PASSWORD('password')");

            // Process the results
            while (rs.next()) {
                usersWithIntegrityFailure.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Error in connecting to the database");
        } finally {
            // Close the statement and connection
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return usersWithIntegrityFailure;
    }
}