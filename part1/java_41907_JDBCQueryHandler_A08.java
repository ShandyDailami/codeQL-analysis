import java.sql.*;

public class java_41907_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";

    // Main method
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
            String sql = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            while (rs.next()) {
                System.out.println("Found a student in the database.");
                System.out.println("ID: " + rs.getString("ID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Age: " + rs.getString("Age"));
            }
            // Step 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean-up environment
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}