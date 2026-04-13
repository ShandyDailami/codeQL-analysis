import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06340_JDBCQueryHandler_A08 {

    // A08_IntegrityFailure: Database credentials should not be hardcoded.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // A08_IntegrityFailure: Secure connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            // A08_IntegrityFailure: Handle exceptions properly
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            // A08_IntegrityFailure: Close resources when done
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return rs;
    }
}