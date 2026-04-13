import java.sql.*;

public class java_12020_JDBCQueryHandler_A01 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare a statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            String sql = "SELECT * FROM Users WHERE username = 'John' AND password = 'Test123'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 5: Retrieve the result set
            while (rs.next()) {
                // Print out the result set
                System.out.println("Found user: " + rs.getString("username"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Step 6: Close the statement and the connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}