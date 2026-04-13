import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37299_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test";

    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName(DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            rs = stmt.executeQuery("SELECT * FROM Users WHERE password = 'password'");

            // Extract data from result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(username + ", " + password);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if(rs != null) rs.close(); } catch(SQLException se2) {}
            try { if(stmt != null) stmt.close(); } catch(SQLException se1) {}
            try { if(conn != null) conn.close(); } catch(SQLException se) { se.printStackTrace(); }
        }
    }
}