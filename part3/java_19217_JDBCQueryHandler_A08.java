import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_19217_JDBCQueryHandler_A08 {

    // Define database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "user";
    private static final String PASS = "password";

    public void handleQuery() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare SQL statement
            String sql = "SELECT COUNT(*) FROM employees WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            // Set parameter
            stmt.setInt(1, 1234);

            // Execute statement
            stmt.execute();

            // Get result
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Count: " + count);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close statement and connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}