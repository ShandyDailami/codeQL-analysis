import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03145_SessionManager_A01 {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 3. Create a statement
            stmt = conn.createStatement();

            // 4. Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users");

            // 5. Retrieve data from result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // 6. Close the statement and connection
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 7. Close the result set, statement, and connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}