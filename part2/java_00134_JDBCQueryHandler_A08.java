import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_00134_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to MySQL
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare SQL statement
            String sql = "UPDATE my_table SET my_column = my_value WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            // Set parameter value
            stmt.setInt(1, 100);

            // Step 4: Execute SQL statement
            stmt.executeUpdate();

            // Step 5: Process the Result Set
            // ...

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (stmt != null) {
                try { stmt.close(); } catch(SQLException e) { /* ignored */ }
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) { /* ignored */ }
            }
        }
    }
}