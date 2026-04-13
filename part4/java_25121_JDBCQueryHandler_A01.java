import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25121_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName(DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 4: Extract data from result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}