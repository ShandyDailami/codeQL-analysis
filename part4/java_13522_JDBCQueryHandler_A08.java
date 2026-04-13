import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13522_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO employees (id, name, salary) VALUES (1, 'John', 3000)";
            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean-up environment
            try {
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}